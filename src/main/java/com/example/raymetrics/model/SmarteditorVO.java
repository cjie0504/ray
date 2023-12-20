package com.example.raymetrics.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class SmarteditorVO {
    private MultipartFile filedata;
    private String callback;
    private String callback_func;
}
