package com.codefest.ejcraft.controller;

import com.codefest.ejcraft.model.JiraCardModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JiraInputController {
    @RequestMapping("/")
    public String input(Model model) {

        model.addAttribute("card-names", new JiraCardModel());

        return "input";
    }

    @RequestMapping(value = "/results", method = RequestMethod.POST)
    public String getJiraTicketList(@ModelAttribute JiraCardModel jiraCards) {
        List<String> jiraList = new ArrayList<>();

        // call jira controller to fetch card information




        return "results";
    }

}
