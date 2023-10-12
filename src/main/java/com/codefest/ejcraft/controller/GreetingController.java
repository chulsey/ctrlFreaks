package com.codefest.ejcraft.controller;

import com.codefest.ejcraft.model.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GreetingController {

    @GetMapping("/ejcraft")
    public String greetingForm(Model model) {
        model.addAttribute("greeting", new Greeting());
        return "greeting";
    }

    @PostMapping("/ejcraft")
    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {


        greeting.setResult("test result");
        model.addAttribute("greeting", greeting);

        return "hello";
    }

}