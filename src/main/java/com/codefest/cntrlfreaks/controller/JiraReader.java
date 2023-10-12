package com.codefest.cntrlfreaks.controller;


import com.codefest.cntrlfreaks.service.GetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/jira")
public class JiraReader {
    @Autowired
    private GetInfoService getInfoService;

    @GetMapping(value = "/info")
    public String getInfo() {

        return getInfoService.getInfo();
    }
}
