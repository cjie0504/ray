package com.example.raymetrics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryReqDTO {
    private String name;
    private String company;
    private String email;
    private String phone;
    private String pw;
    private String title;
    private String contents;
}
