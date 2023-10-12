package com.codefest.ejcraft.service;

import com.codefest.ejcraft.models.ChatRequest;
import com.codefest.ejcraft.models.ChatResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OpenAIService {

  @Qualifier("openaiRestTemplate") @Autowired
  private RestTemplate restTemplate;

  @Value("${openai.model}")
  private String model;

  @Value("${openai.api.url}")
  private String apiUrl;

  /**
   * @param prompt String to input to Open AI
   * @return String response from AI
   */
  public String generateSummary(String prompt) {
    // create a request
    ChatRequest request = new ChatRequest(model, prompt);

    // call the API
    ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

    if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
      return "No response";
    }
    // return the first response
    return response.getChoices().get(0).getMessage().getContent();
  }
}
