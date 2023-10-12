package com.codefest.ejcraft.service;

import com.codefest.ejcraft.models.pojo.JiraResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class GetInfoService {

  @Autowired private RestTemplate restTemplate;

  @Autowired
  @Qualifier("getJiraInfoExecutor") private Executor getJiraInfoExecutor;

  @Value("${jira.username}")
  private String username;

  @Value("${jira.authkey}")
  private String authKey;

  public Map<String, List<String>> getInfo(List<String> jiraNumbers) {
    List<CompletableFuture<Map<String, List<String>>>> completableFutures = new ArrayList<>();
    Map<String, List<String>> res = new HashMap<>();

    for (String jiraNo : jiraNumbers) {
      completableFutures.add(
          CompletableFuture.supplyAsync(() -> getSingleJiraInfo(jiraNo), getJiraInfoExecutor)
              .exceptionally(
                  t -> {
                    log.error(t.getMessage());
                    return null;
                  }));
    }

    for (CompletableFuture completableFuture : completableFutures) {
      Map<String, List<String>> singleRes = (Map<String, List<String>>) completableFuture.join();
      if (!CollectionUtils.isEmpty(singleRes)) {
        res.putAll(singleRes);
      }
    }

    return res;
  }

  private Map<String, List<String>> getSingleJiraInfo(String jiraNumber) {
    HttpHeaders httpHeaders = createHeaders(username, authKey);
    HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);

    String url = "https://codeFest23.atlassian.net/rest/api/2/issue/" + jiraNumber;

    ResponseEntity<JiraResponse> response =
        restTemplate.exchange(url, HttpMethod.GET, requestEntity, JiraResponse.class);

    JiraResponse jiraResponse = response.getBody();
    Map<String, List<String>> res = new HashMap<>();
    if (jiraResponse == null) {
      return res;
    }
    String description = jiraResponse.getFields().getDescription();
    log.info("description::{}", description);
    String title = jiraResponse.getFields().getSummary();
    log.info("title::{}", title);
    List<String> infoList = new ArrayList<>();
    infoList.add(title);
    infoList.add(description);
    res.put(jiraNumber, infoList);
    return res;
  }

  HttpHeaders createHeaders(String username, String password) {
    return new HttpHeaders() {
      {
        String auth = username + ":" + password;

        String encodeBytes = Base64.encodeBase64String(auth.getBytes());

        String authHeader = "Basic " + encodeBytes;
        set("Authorization", authHeader);
      }
    };
  }
}
