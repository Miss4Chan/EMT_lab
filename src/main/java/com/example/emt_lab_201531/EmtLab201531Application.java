package com.example.emt_lab_201531;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class EmtLab201531Application {

    public static void main(String[] args) {
        SpringApplication.run(EmtLab201531Application.class, args);
    }

}
