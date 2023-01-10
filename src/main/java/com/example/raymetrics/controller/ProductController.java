package com.example.raymetrics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    @RequestMapping(value= "/customPrinted", method = RequestMethod.GET)
    public String customPrinted() {
        return "/company/blog";
    }

    @RequestMapping(value= "/radiationDetector", method = RequestMethod.GET)
    public String radiationDetector() {
        return "/company/blog";
    }

    @RequestMapping(value= "/patientTailored", method = RequestMethod.GET)
    public String patientTailored() {
        return "/company/blog";
    }

}
