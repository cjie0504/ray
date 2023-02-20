package com.example.raymetrics.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RAndDController {
    @RequestMapping(value = "/RAndD", method = RequestMethod.GET)
    public String rAndD(){
        return "/rAndD/3dPlasticScintillator";
    }

    @RequestMapping(value = "/plasticScintillator", method = RequestMethod.GET)
    public String plasticScintillator(){
        return "/rAndD/3dPlasticScintillator";
    }

    @RequestMapping(value = "/aiAssisted", method = RequestMethod.GET)
    public String aiAssisted(){
        return "/rAndD/aiAssistedRadiationInstrument";
    }

    @RequestMapping(value = "/radiotherapyDosimetry", method = RequestMethod.GET)
    public String radiotherapyDosimetry(){
        return "/rAndD/3dRadiotherapyDosimetry";
    }

    @RequestMapping(value = "/patent", method = RequestMethod.GET)
    public String patent(){
        return "/rAndD/patent";
    }
}
