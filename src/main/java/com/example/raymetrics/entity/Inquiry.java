package com.example.raymetrics.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@DynamicInsert
@DynamicUpdate
@Table(name = "INQUIRY")
public class Inquiry extends AuditingAt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inquiryNo;
    private String title;
    private String email;
    private String name;
    private String phone;
    private String company;
    private String pw;
    private String contents;
    @OneToMany(mappedBy = "inquiry", fetch = FetchType.LAZY)
    private List<InquiryReply> replies = new ArrayList<>();

    public Inquiry(HashMap<String, Object> param){
        this.title = String.valueOf(param.get("title"));
        this.email = String.valueOf(param.get("email"));
        this.name = String.valueOf(param.get("writer"));
        this.phone = String.valueOf(param.get("email"));
        this.company = String.valueOf(param.get("company"));
        this.pw = String.valueOf(param.get("pw"));
        this.contents = String.valueOf(param.get("smartEditor"));
    }
}
