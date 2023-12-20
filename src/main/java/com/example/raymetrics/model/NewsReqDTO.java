package com.example.raymetrics.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewsReqDTO {
    private String name;
    private String title;
    private String contents;
}
