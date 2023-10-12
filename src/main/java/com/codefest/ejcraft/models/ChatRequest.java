package com.codefest.ejcraft.models;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class ChatRequest {

  private String model;
  private List<Message> messages;

  @Value("${openai.n}")
  private int n = 1;

  @Value("${openai.temperature}")
  private double temperature;

  public ChatRequest(String model, String prompt) {
    this.model = model;

    this.messages = new ArrayList<>();
    this.messages.add(new Message("user", prompt));
  }
}
