package com.example.raymetrics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryReplyReqDTO {
    private String contents;
    private int inquiryNo;
    private int regAdminNo;
}
