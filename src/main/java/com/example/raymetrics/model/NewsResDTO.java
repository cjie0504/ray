package com.example.raymetrics.model;

import com.example.raymetrics.entity.Inquiry;
import com.example.raymetrics.entity.InquiryReply;
import com.example.raymetrics.entity.News;
import com.google.api.client.util.DateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewsResDTO {
    private int newsNo;
    private String title;
    private String contents;
    private String regAdminNo;
    private Date regDt;


    public static NewsResDTO of(News news){
        return new NewsResDTO(
                news.getNewsNo(),
                news.getTitle(),
                news.getContents(),
                news.getRegAdminNo(),
                news.getRegDt()
        );
    }

}
