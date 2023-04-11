package com.example.raymetrics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.w3c.dom.ls.LSOutput;

@SpringBootApplication
public class RaymetricsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(RaymetricsApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(RaymetricsApplication.class, args);
    }

}
