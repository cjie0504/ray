package com.example.raymetrics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CompanyController {

    @RequestMapping(value= "/company", method = RequestMethod.GET)
    public String company() {
        return "/company/blog";
    }

    @RequestMapping(value= "/corportaion", method = RequestMethod.GET)
    public String corporation() {
        return "/company/blog";
    }

    @RequestMapping(value= "/managementPhilosophy", method = RequestMethod.GET)
    public String managementPhilosophy() {
        return "/company/blog";
    }

    @RequestMapping(value= "/history", method = RequestMethod.GET)
    public String history() {
        return "/company/blog";
    }
    @RequestMapping(value= "/organization", method = RequestMethod.GET)
    public String organization() {
        return "/company/blog";
    }
    @RequestMapping(value= "/news", method = RequestMethod.GET)
    public String news() {
        return "/company/blog";
    }
}
