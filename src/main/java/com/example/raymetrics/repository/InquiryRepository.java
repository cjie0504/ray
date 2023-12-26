package com.example.raymetrics.repository;

import com.example.raymetrics.entity.Inquiry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//public interface InquiryRepository extends GenericRepository<Inquiry>
public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
    Page<Inquiry> findAllByOrderByInquiryNoDesc(PageRequest pageable);
    Inquiry findFirstByInquiryNo(int inquiryNo);
    Inquiry findFirstByInquiryNoAndPw(int inquiryNo, String pw);
    Optional<Inquiry> findTop1ByInquiryNoAndNameAndPw(int inquiryNo, String name, String pw);
//    void delete(Inquiry inquiry);

}
