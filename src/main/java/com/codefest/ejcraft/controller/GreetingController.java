package com.codefest.ejcraft.controller;

import com.codefest.ejcraft.models.Greeting;
import com.codefest.ejcraft.service.PassJiraNumberService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

  @Autowired PassJiraNumberService passJiraNumberService;

  @GetMapping("/ejcraft")
  public String greetingForm(Model model) {
    model.addAttribute("greeting", new Greeting());
    return "greeting";
  }

  @PostMapping("/ejcraft")
  public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {

    List<String> jiraNumbers = new ArrayList<>();

    if(greeting == null){
      throw new RuntimeException("BAD REQUEST");
    }

    String input = greeting.getContent();
    if (input.contains(",")) {
      String[] inputs = input.split(",");
      for(String str : inputs){
        jiraNumbers.add(str);
      }
    }else {
      jiraNumbers.add(input);
    }

    String resultList = passJiraNumberService.getChangeDoc(jiraNumbers);

    greeting.setResult(resultList);

    model.addAttribute("greeting", greeting);

    return "hello";
  }
}
