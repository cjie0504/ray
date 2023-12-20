package com.example.raymetrics.repository;

import com.example.raymetrics.entity.InquiryReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface InquiryRepository extends GenericRepository<Inquiry>
public interface InquiryReplyRepository extends JpaRepository<InquiryReply, Integer> {
    InquiryReply findFirstByReplyNoAndInquiry_InquiryNo(int replyNo, int inquiryNo);
    List<InquiryReply> findAllByInquiry_InquiryNo(int inquiryNo);
    void delete(InquiryReply inquiryReply);
}
