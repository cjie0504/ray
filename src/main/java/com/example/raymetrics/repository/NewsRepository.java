package com.example.raymetrics.repository;

import com.example.raymetrics.entity.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//public interface InquiryRepository extends GenericRepository<Inquiry>
public interface NewsRepository extends JpaRepository<News, Integer> {
    Page<News> findAllByOrderByNewsNoDesc(PageRequest pageable);
    News findFirstByNewsNo(int newsNo);

}
