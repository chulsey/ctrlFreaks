package com.codefest.ejcraft.controller;

import static com.codefest.ejcraft.constants.EJCraftConstant.DESCRIPTION;
import static com.codefest.ejcraft.constants.EJCraftConstant.SUMMARY;

import com.codefest.ejcraft.models.Greeting;
import com.codefest.ejcraft.service.PassJiraNumberService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.util.StringUtils;

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

    if (greeting == null || StringUtils.isEmpty(greeting.getContent())) {
      //      throw new RuntimeException("BAD REQUEST");
      return "error";
    }

    String input = greeting.getContent();
    try {
      if (input.contains(",")) {
        String[] inputs = input.split(",");
        for (String str : inputs) {
          jiraNumbers.add(str);
        }
      } else {
        jiraNumbers.add(input);
      }


    Map<String, String> resultMap = passJiraNumberService.getChangeDoc(jiraNumbers);

    greeting.setSummary(resultMap.get(SUMMARY));
    greeting.setDescription(resultMap.get(DESCRIPTION));
    } catch (Throwable t) {
      return "error";
    }
    model.addAttribute("greeting", greeting);

    return "hello";
  }
}
