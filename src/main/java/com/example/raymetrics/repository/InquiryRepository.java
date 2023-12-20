package com.example.raymetrics.repository;

import com.example.raymetrics.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//public interface InquiryRepository extends GenericRepository<Inquiry>
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
    List<Inquiry> findAllByOrderByInquiryNoDesc();
    Inquiry findFirstByInquiryNo(int inquiryNo);
    Inquiry findFirstByInquiryNoAndPw(int inquiryNo, String pw);
//    void delete(Inquiry inquiry);
}
