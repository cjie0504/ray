package com.example.raymetrics.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.security.SecureRandom;
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
    private String token;
    @OneToMany(mappedBy = "inquiry", fetch = FetchType.LAZY)
    private List<InquiryReply> replies = new ArrayList<>();

    public Inquiry(HashMap<String, Object> param){
        this.title = String.valueOf(param.get("title"));
        this.email = String.valueOf(param.get("email"));
        this.name = String.valueOf(param.get("name"));
        this.phone = String.valueOf(param.get("phone"));
        this.company = String.valueOf(param.get("company"));
        this.pw = String.valueOf(param.get("pw"));
        this.contents = String.valueOf(param.get("smartEditor"));
    }

    //본인 확인을 위해 난수사용
    public void setToken(){
        // 안전한 난수 생성을 위한 SecureRandom 인스턴스
        SecureRandom secureRandom = new SecureRandom();

        // 랜덤 폴더명 길이 설정 (예: 16글자)
        int folderNameLength = 5;

        // 랜덤 폴더명 생성
        StringBuilder folderNameBuilder = new StringBuilder(folderNameLength);
        for (int i = 0; i < folderNameLength; i++) {
            // 'a'부터 'z' 사이의 랜덤 알파벳을 추가
            folderNameBuilder.append((char) ('a' + secureRandom.nextInt(26)));
        }

        this.token = folderNameBuilder.toString();
    }

    public Inquiry setContents(String contents){
        this.contents = contents;
        return this;
    }
}
