package com.example.raymetrics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RAndDController {
    @RequestMapping(value = "/RAndD", method = RequestMethod.GET)
    public String rAndD(){
        return "/company/blog";
    }

    @RequestMapping(value = "/plasticScintillator", method = RequestMethod.GET)
    public String plasticScintillator(){
        return "/company/blog";
    }

    @RequestMapping(value = "/aiAssisted", method = RequestMethod.GET)
    public String aiAssisted(){
        return "/company/blog";
    }

    @RequestMapping(value = "/radiotherapyDosimetry", method = RequestMethod.GET)
    public String radiotherapyDosimetry(){
        return "/company/blog";
    }

    @RequestMapping(value = "/patent", method = RequestMethod.GET)
    public String patent(){
        return "/company/blog";
    }
}
