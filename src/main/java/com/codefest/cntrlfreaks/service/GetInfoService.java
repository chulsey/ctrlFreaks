package com.codefest.cntrlfreaks.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;


@Service
public class GetInfoService {

    @Autowired
    private RestTemplate restTemplate;


    public String getInfo(){
        final RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = createHeaders("jinliu1299@gmail.com", "ATATT3xFfGF0PJGUYAJjdQmqjYAT4SSIeIzfJPpqOGY8nfTxpTUq8kYOdS2-0ENqC2hu0mrfm9UNDJO_bp7mwsgQCbJQP4wp13y0uNY-Hx_77bIgWNANaJOsaMsUAnpwfTArTV1vpxAmRjRILA4GrywyEQ-oBIatrVaBwrDhCnClcu1xSUHBarQ=A216E3F2");
        HttpEntity<Void> requestEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://codeFest23.atlassian.net/rest/api/2/issue/COD-2", HttpMethod.GET, requestEntity, String.class);
//        final String response = restTemplate.getForObject("https://codeFest23.atlassian.net/rest/api/2/issue/COD-2", String.class);

        System.out.println(response);
        return "hello Jira Service";
    }

    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;

            String encodeBytes = Base64.encodeBase64String(auth.getBytes());

            String authHeader = "Basic " +  encodeBytes;
            set( "Authorization", authHeader );
        }};
    }
}
