package com.example.raymetrics.service;

import com.example.raymetrics.entity.Inquiry;
import com.example.raymetrics.entity.InquiryReply;
import com.example.raymetrics.model.InquiryResDTO;
import com.example.raymetrics.repository.InquiryReplyRepository;
import com.example.raymetrics.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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
            result.add(InquiryResDTO.of(inquiry,"inquiry글쓴이"));
        });
        return inquiryList;
    }

    @Transactional(readOnly = true)
    public InquiryResDTO getOne(int id){
        Optional<Inquiry> inquiry = inquiryRepository.findById(id);
        if(inquiry.isPresent()){
            return InquiryResDTO.of(inquiry.get(),"inquiry글쓴이");
        }else {
            return null;
        }
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
