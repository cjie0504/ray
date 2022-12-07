package com.example.raymetrics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    //메인페이지
    @GetMapping(value = "/test")
    public String test(){
        
        return "test";
    }


    @RequestMapping(value= "/")
    public String index() {
        return "index";
    }

}


