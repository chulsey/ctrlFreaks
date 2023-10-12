package com.codefest.ejcraft.controller;

import com.codefest.ejcraft.api.ChangeRequestApi;
import com.codefest.ejcraft.api.model.ChangeRequest;
import com.codefest.ejcraft.service.GetInfoService;
import com.codefest.ejcraft.service.OpenAIService;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EJCRaftController implements ChangeRequestApi {

  @Autowired private GetInfoService getInfoService;

  @Autowired private OpenAIService openAIService;

  @Override
  public ResponseEntity<ChangeRequest> startChangeRequest(List<String> requestBody) {
    // Get Info from Jira
    // get Jira number from front end requestBody
    if (CollectionUtils.isEmpty(requestBody)) {
      throw new RuntimeException("Bad Request no input from user");
    }
    Map<String, List<String>> body = getInfoService.getInfo(requestBody);

    System.out.println("******** RESPONSE FROM JIRA API ********");
    System.out.println(body.toString());

    // getting Jira titles and numbers
    System.out.println(body.keySet());
    Set<String> keySet = body.keySet();

    StringBuilder jiraTitles = new StringBuilder();
    StringBuilder jiraDesc = new StringBuilder();

    for (String key : keySet) {
      System.out.println(key);
      System.out.println(body.get(key).get(0)); // 0 is the title of the Jira's
      jiraTitles.append(body.get(key).get(0)).append(", ");
      jiraDesc.append(body.get(key).get(1)).append(": ");
    }
    System.out.println("***** JIRA TITLES *****");
    System.out.println(jiraTitles);

    // Call ChatGPT
    // use output of summary and description to send to ChatGPT to generate summary
    String openAISummaryResponse =
        openAIService.generateSummary(
            "Summarize these Jira titles"
                + "in a way that a non-technical person would understand for a release explanation"
                + "in a single sentence "
                + jiraTitles);

    // Call CHAT GPT to generate a summary of all the Jira descriptions
    System.out.println("***** JIRA DESCRIPTIONS *****");
    System.out.println(jiraDesc);

    String openAIDescResponse =
        openAIService.generateSummary(
            "Summarize these Jira"
                + " descriptions in a way a non-technical person would understand "
                + "into a single paragraph: "
                + jiraDesc);

    ChangeRequest changeRequest = new ChangeRequest();
    changeRequest.setSummary(openAISummaryResponse);
    changeRequest.setDescription(openAIDescResponse);

    return ResponseEntity.status(HttpStatus.OK).body(changeRequest);
  }
}
