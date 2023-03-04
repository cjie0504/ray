package com.example.raymetrics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactUsController {

    @RequestMapping(value= "/contactUs", method = RequestMethod.GET)
    public String contactUs() {
        return "/contactUs/contact";
    }

    @RequestMapping(value= "/inquiry", method = RequestMethod.GET)
    public String inquiry() {
        return "/contactUs/inquiry";
    }

}
