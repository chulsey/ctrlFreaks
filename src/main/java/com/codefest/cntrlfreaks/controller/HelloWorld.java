package com.codefest.cntrlfreaks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping(value = "/hello")
    public String homePage() {
System.out.println("HEREHRERHE");
        return "HelloWorld";
    }

}
