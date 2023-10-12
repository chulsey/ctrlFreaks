package com.codefest.ejcraft.service;

import com.codefest.ejcraft.api.model.ChangeRequest;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class PassJiraNumberService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.start.changerequest.url}")
    private String openAiUrl;

    public String getChangeDoc(List<String> jiraNumbers) {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<Object> requestEntity = new HttpEntity<>(jiraNumbers, httpHeaders);
        List<String> jiraList = new ArrayList<>();
        ResponseEntity<ChangeRequest> response = restTemplate.exchange(openAiUrl, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<ChangeRequest>() {});

        ChangeRequest body = response.getBody();

        return body.getSummary();
    }


    }


