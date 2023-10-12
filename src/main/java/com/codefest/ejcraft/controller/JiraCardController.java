package com.codefest.ejcraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JiraCardController {
    @RequestMapping("/")
    public String input() { return "input"; }

    @PostMapping("/submit")
    public List<String> getJiraTicketList() {
        List<String> jiraList = new ArrayList<>();

        return jiraList;
    }

}
