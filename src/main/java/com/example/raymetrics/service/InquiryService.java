package com.example.raymetrics.service;

import com.example.raymetrics.entity.Inquiry;
import com.example.raymetrics.entity.InquiryReply;
import com.example.raymetrics.model.InquiryResDTO;
import com.example.raymetrics.repository.InquiryReplyRepository;
import com.example.raymetrics.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final InquiryReplyRepository inquiryReplyRepository;
    @Transactional
    public int regist(HashMap<String, Object> paramMap){
        int inquiry_no = 0;
        try {
            Inquiry inquiry = inquiryRepository.save(new Inquiry(paramMap));
            inquiry_no = inquiry.getInquiryNo();

        }catch (Exception e){

        }
        return inquiry_no;
    }


    @Transactional(readOnly = true)
    public List<Inquiry> getList(){
        List<InquiryResDTO> result = new ArrayList<>();

        List<Inquiry> inquiryList = inquiryRepository.findAllByOrderByInquiryNoDesc();
        inquiryList.forEach(inquiry -> {
            if(inquiry.getReplies()!=null){
                inquiry.getReplies().forEach(
                        inquiryReply -> inquiryReply.setWriter("reply글쓴이")
                );
            }
            result.add(InquiryResDTO.of(inquiry));
        });
        return inquiryList;
    }

    @Transactional(readOnly = true)
    public InquiryResDTO getOne(int id){
        Optional<Inquiry> inquiry = inquiryRepository.findById(id);
        if(inquiry.isPresent()){
            return InquiryResDTO.of(inquiry.get());
        }else {
            return null;
        }
    }
    @Transactional(readOnly = true)
    public InquiryResDTO checkWriter(Map<String,Object> param){
        int inquiryNo = Integer.parseInt(param.get("inquiryNo").toString());
        String name = param.get("name").toString();
        String pw = param.get("pw").toString();

        Optional<Inquiry> inquiry = inquiryRepository.findTop1ByInquiryNoAndNameAndPw(inquiryNo,name,pw);
        if(inquiry.isPresent()){
            return InquiryResDTO.of(inquiry.get());
        }else {
            return null;
        }
    }

    public boolean uploadImg(HttpServletRequest request, HttpServletResponse response){
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
            return false;
        }
        return true;
    }


    @Transactional
    public void reply(HashMap<String, Object> paramMap) throws Exception{
        try{
            if(paramMap!=null) {
                Optional<Inquiry> inquiry = inquiryRepository.findById(Integer.parseInt(paramMap.get("inquiryNo").toString()));
                InquiryReply inquiryReply = new InquiryReply(paramMap, inquiry.get());

                inquiryReplyRepository.save(inquiryReply);
            }else {
                throw new Exception("param 빈값임");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    public Boolean deleteReply(int replyNo, int inquiryNo){
        try{
            InquiryReply inquiryReply = inquiryReplyRepository.findFirstByReplyNoAndInquiry_InquiryNo(replyNo,inquiryNo);
            if(inquiryReply!=null){
                inquiryReplyRepository.delete(inquiryReply);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional
    public Boolean deleteInquiry(int inquiryNo){
        try{
            Inquiry inquiry = inquiryRepository.findFirstByInquiryNo(inquiryNo);
            if(inquiry!=null){
                //관련 댓글삭제
                List<InquiryReply> inquiryReplyList = inquiryReplyRepository.findAllByInquiry_InquiryNo(inquiryNo);
                if(inquiryReplyList.size()>0){
                    inquiryReplyList.forEach(inquiryReply -> inquiryReplyRepository.delete(inquiryReply));
                }

                //게시글삭제
                inquiryRepository.delete(inquiry);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Transactional(readOnly = true)
    public Boolean checkPw(int inquiryNo, String pw){
        Inquiry inquiry = inquiryRepository.findFirstByInquiryNoAndPw(inquiryNo, pw);
        if(inquiry!=null){
            return true;
        }
        return false;
    }



}
