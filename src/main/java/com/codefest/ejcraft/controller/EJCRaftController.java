package com.codefest.ejcraft.controller;

import com.codefest.ejcraft.api.ChangeRequestApi;
import com.codefest.ejcraft.api.model.ChangeRequest;
import com.codefest.ejcraft.models.ChatRequest;
import com.codefest.ejcraft.models.ChatResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class EJCRaftController implements ChangeRequestApi {

  @Qualifier("openaiRestTemplate") @Autowired
  private RestTemplate restTemplate;

  @Value("${openai.model}")
  private String model;

  @Value("${openai.api.url}")
  private String apiUrl;

  @Override
  public ResponseEntity<ChangeRequest> startChangeRequest(List<String> requestBody) {
    // TODO: Get Info from Jira
    // get Jira number from front end requestBody
    // call Jira for summary and description

    // TODO: Call ChatGPT
    // use output of summary and description to send to ChatGPT to generate summary
    // generateSummary(prompt);

    ChangeRequest changeRequest = new ChangeRequest();

    // TODO: Replace with data from ChatGPT
    changeRequest.setSummary("Stuff");
    changeRequest.setDescription("More stuff");

    return ResponseEntity.ok(changeRequest);
  }

  @GetMapping("/chat")
  public String generateSummary(@RequestParam String prompt) {
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
