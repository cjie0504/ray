package com.example.raymetrics.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashMap;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@Table(name = "INQUIRY_REPLY")
public class InquiryReply extends AuditingAt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int replyNo;
//    private int inquiryNo;
    private String contents;
    private Integer regAdminNo;
    private Integer modAdminNo;
    // 1:N 관계를 매핑하는 필드 추가
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INQUIRY_NO")
    private Inquiry inquiry;
    @Transient
    private String writer;

    public InquiryReply(HashMap<String, Object> param, Inquiry inquiry){
//        this.inquiryNo = Integer.parseInt((String) param.get("inquiryNo"));
        this.contents = String.valueOf(param.get("contents"));
        this.regAdminNo = Integer.parseInt(param.get("regAdminNo").toString());
        this.inquiry = inquiry;
    }
    public void setWriter(String writer){
        this.writer = writer;
    }
}
