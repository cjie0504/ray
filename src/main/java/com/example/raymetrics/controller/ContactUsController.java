package com.example.raymetrics.controller;

import com.example.raymetrics.entity.Inquiry;
import com.example.raymetrics.model.InquiryResDTO;
import com.example.raymetrics.service.FileUploadService;
import com.example.raymetrics.service.InquiryService;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ContactUsController {
    private final InquiryService inquiryService;
    private final FileUploadService fileUploadService;

    @RequestMapping(value= "/contactUs", method = RequestMethod.GET)
    public String contactUs() {
        return "/contactUs/contact";
    }

    @RequestMapping(value= "/inquiry", method = RequestMethod.GET)
    public String inquiry(@RequestParam Map<String,Object> param, Model model) {
        Page<InquiryResDTO> inquiryList = inquiryService.getList(param);


        int pageBlock = 10;
        int page = inquiryList.getNumber()+1;

        // 현재 페이지 블록
        int currentBlock = (int) Math.ceil((double) page / pageBlock);

        // 페이지 블록 시작 페이지
        int startPage = (currentBlock - 1) * pageBlock + 1;

        // 페이지 블록 끝 페이지
        int endPage = Math.min(startPage + pageBlock - 1, inquiryList.getTotalPages());
        endPage = Math.max(endPage, 1);

        model.addAttribute("INQUIRY_LIST", inquiryList);
        model.addAttribute("START_PAGE", startPage);
        model.addAttribute("END_PAGE", endPage);


        return "/contactUs/inquiry";
    }


    /**
     * 글쓰기 페이지로 이동
     * @param model
     * @return
     */
    @RequestMapping(value= "/contactUs/inquiryRegister", method = RequestMethod.GET)
    public String inquiryRegister(Model model) {
        model.addAttribute("folderPath",generateRandomFolderName());
        return "/contactUs/inquiryRegister";
    }

    /**
     * 파일업로드
     * @param request
     * @param response
     */
    @RequestMapping(value= "/contactUs/inquiryRegister/upload", method = RequestMethod.POST)
    public void smarteditorMultiImageUpload(HttpServletRequest request, HttpServletResponse response) {

        fileUploadService.uploadImg(request,response);

    }

    /**
     * 등록(SAVE)
     * @param paramMap
     * @return
     */
    @PostMapping(value = "/contactUs/inquiry")
    public String regist(@RequestParam HashMap<String, Object> paramMap, RedirectAttributes attributes) throws IOException {
        Inquiry inquiry = inquiryService.regist(paramMap);
        fileUploadService.uploadImgToCloud(inquiry);

//        return "redirect:/inquiry/detail/"+inquiry.getInquiryNo();
        return "redirect:/inquiry";
    }

    /**
     * 패스워드 체크
     * @param paramMap
     * @param model
     * @param attributes
     * @return
     */
    @RequestMapping(value= "/inquiry/checkPw", method = RequestMethod.POST)
    public String inquiryPwCheck( @RequestParam HashMap<String, Object> paramMap ,Model model, RedirectAttributes attributes) {

        InquiryResDTO inquiry = inquiryService.checkWriter(paramMap);

        if(inquiry!=null){
            attributes.addAttribute("TOKEN",inquiry.getToken());

            return "redirect:/inquiry/detail/"+inquiry.getInquiryNo();
        }else {
            return "redirect:/inquiry";
        }
    }

    /**
     * 상세페이지
     * @param inquiryNo
     * @param model
     * @return
     */
    @RequestMapping(value= "/inquiry/detail/{inquiryNo}", method = RequestMethod.GET)
    public String inquiry(@PathVariable("inquiryNo") int inquiryNo, Model model, @RequestParam Map<String,Object> param) {

        InquiryResDTO inquiry = inquiryService.getOne(inquiryNo);
        model.addAttribute("INQUIRY",inquiry);

        if(param.get("TOKEN")!=null
                && (inquiry.getToken()!=null && inquiry.getToken().equals(param.get("TOKEN")))){
            return "/contactUs/inquiryDetail";
        }else {
            return "/contactUs/inquiryCheckPw";
        }
    }


    @GetMapping("/contactUs/test")
    public void uploadFile() throws IOException {
        Bucket bucket = StorageClient.getInstance().bucket("raymetrics-57ba9.appspot.com");
        InputStream fileContent = new FileInputStream("C:\\Users\\Kihong\\IdeaProjects\\Raymetrics\\src\\main\\webapp\\resources\\uploadImg\\test.jpg");
        Blob blob = bucket.create("test", fileContent, "image/jpg")
                ;
    }
    public static String generateRandomFolderName() {
        // 안전한 난수 생성을 위한 SecureRandom 인스턴스
        SecureRandom secureRandom = new SecureRandom();

        // 랜덤 폴더명 길이 설정 (예: 16글자)
        int folderNameLength = 5;

        // 랜덤 폴더명 생성
        StringBuilder folderNameBuilder = new StringBuilder(folderNameLength);
        for (int i = 0; i < folderNameLength; i++) {
            // 'a'부터 'z' 사이의 랜덤 알파벳을 추가
            folderNameBuilder.append((char) ('a' + secureRandom.nextInt(26)));
        }

        return folderNameBuilder.toString();
    }
}
