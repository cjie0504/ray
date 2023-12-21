package com.example.raymetrics.controller;

import com.example.raymetrics.model.InquiryResDTO;
import com.example.raymetrics.service.InquiryService;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import lombok.RequiredArgsConstructor;
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

@Controller
@RequiredArgsConstructor
public class ContactUsController {
    private final InquiryService inquiryService;

    @RequestMapping(value= "/contactUs", method = RequestMethod.GET)
    public String contactUs() {
        return "/contactUs/contact";
    }

    @RequestMapping(value= "/inquiry", method = RequestMethod.GET)
    public String inquiry() {
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

        inquiryService.uploadImg(request,response);

    }

    /**
     * 등록(SAVE)
     * @param paramMap
     * @return
     */
    @PostMapping(value = "/contactUs/inquiry")
    public String regist(@RequestParam HashMap<String, Object> paramMap, RedirectAttributes attributes){
        int inquiry_no = inquiryService.regist(paramMap);
        attributes.addAttribute("WRITER","Y");

        return "redirect:/inquiry/detail/"+inquiry_no;
    }
    @RequestMapping(value= "/inquiry/checkPw", method = RequestMethod.POST)
    public String inquiryPwCheck( @RequestParam HashMap<String, Object> paramMap ,Model model, RedirectAttributes attributes) {

        InquiryResDTO inquiry = inquiryService.checkWriter(paramMap);

        if(inquiry!=null){
            attributes.addAttribute("WRITER","Y");
            return "redirect:/inquiry/detail/"+inquiry.getInquiryNo();
        }else {
            return "redirect:/inquiry";
        }
    }

    @RequestMapping(value= "/inquiry/detail/{inquiryNo}", method = RequestMethod.GET)
    public String inquiry(@PathVariable("inquiryNo") int inquiryNo, Model model) {

        InquiryResDTO inquiry = inquiryService.getOne(inquiryNo);
        model.addAttribute("INQUIRY",inquiry);

        if(model.getAttribute("WRITER")!=null
                && "Y".equals(model.getAttribute("WRITER"))){
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
