package com.example.raymetrics.model;

import com.example.raymetrics.entity.InquiryReply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryReplyResDTO {
    private int replyNo;
    private String contents;
    private String writer;

    public static InquiryReplyResDTO of(InquiryReply inquiryReply, String writer){
        return new InquiryReplyResDTO(
                inquiryReply.getReplyNo(),
                inquiryReply.getContents(),
                writer
        );
    }

}
