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
@Table(name = "NEWS")
public class News extends AuditingAt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int newsNo;
    private String title;
    private String contents;
    private Boolean delYn;
    private String regAdminName;
    private String modAdminNo;

    public News(HashMap<String, Object> param){
        this.title = String.valueOf(param.get("title"));
        this.contents = String.valueOf(param.get("smartEditor"));
        this.delYn = Boolean.parseBoolean((String) param.get("delYn"));
        this.regAdminName = String.valueOf(param.get("regAdminName"));
    }


    public News setContents(String contents){
        this.contents = contents;
        return this;
    }
}
