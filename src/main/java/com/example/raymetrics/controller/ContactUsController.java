package com.example.raymetrics.controller;

import com.example.raymetrics.entity.Inquiry;
import com.example.raymetrics.model.InquiryResDTO;
import com.example.raymetrics.model.SmarteditorVO;
import com.example.raymetrics.service.InquiryService;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.UUID;

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
     * 등록
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


    @RequestMapping(value= "/contactUs/inquiryRegister", method = RequestMethod.GET)
    public String inquiryRegister() {
        return "/contactUs/inquiryRegister";
    }


    @RequestMapping(value= "/contactUs/inquiryRegister/upload", method = RequestMethod.POST)
    public void smarteditorMultiImageUpload(HttpServletRequest request, HttpServletResponse response) {

        try {
            //파일정보
            String sFileInfo = "";
            //파일명을 받는다 - 일반 원본파일명
            String sFilename = request.getHeader("file-name");
            //파일 확장자
            String sFilenameExt = sFilename.substring(sFilename.lastIndexOf(".") + 1);
            //확장자를소문자로 변경
            sFilenameExt = sFilenameExt.toLowerCase();

            //이미지 검증 배열변수
            String[] allowFileArr = {"jpg", "png", "bmp", "gif"};

            //확장자 체크
            int nCnt = 0;
            for (int i = 0; i < allowFileArr.length; i++) {
                if (sFilenameExt.equals(allowFileArr[i])) {
                    nCnt++;
                }
            }

            //이미지가 아니라면
            if (nCnt == 0) {
                PrintWriter print = response.getWriter();
                print.print("NOTALLOW_" + sFilename);
                print.flush();
                print.close();
            } else {
                //디렉토리 설정 및 업로드

                //파일경로
                String filePath = "C:\\Users\\Kihong\\IdeaProjects\\Raymetrics\\src\\main\\webapp\\resources\\uploadImg";
                File file = new File(filePath);

                if (!file.exists()) {
                    file.mkdirs();
                }

                String sRealFileNm = "";
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                String today = formatter.format(new java.util.Date());
                sRealFileNm = today + UUID.randomUUID().toString() + sFilename.substring(sFilename.lastIndexOf("."));
                String rlFileNm = filePath+"/" + sRealFileNm;

                ///////////////// 서버에 파일쓰기 /////////////////
                InputStream inputStream = request.getInputStream();
                OutputStream outputStream = new FileOutputStream(rlFileNm);
                int numRead;
                byte bytes[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
                while ((numRead = inputStream.read(bytes, 0, bytes.length)) != -1) {
                    outputStream.write(bytes, 0, numRead);
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                outputStream.flush();
                outputStream.close();

                ///////////////// 이미지 /////////////////
                // 정보 출력
                sFileInfo += "&bNewLine=true";
                // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
                sFileInfo += "&sFileName=" + sFilename;
                sFileInfo += "&sFileURL=" + "/resources/uploadImg/" + sRealFileNm;
                PrintWriter printWriter = response.getWriter();
                printWriter.print(sFileInfo);
                printWriter.flush();
                printWriter.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @GetMapping("/contactUs/test")
    public void uploadFile() throws IOException {
        Bucket bucket = StorageClient.getInstance().bucket("raymetrics-57ba9.appspot.com");
        InputStream fileContent = new FileInputStream("C:\\Users\\Kihong\\IdeaProjects\\Raymetrics\\src\\main\\webapp\\resources\\uploadImg\\test.jpg");
        Blob blob = bucket.create("test", fileContent, "image/jpg")
                ;

    }

}
