package com.codefest.cntrlfreaks.controller;


import com.codefest.cntrlfreaks.service.GetInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/jira")
public class JiraReader {
    @Autowired
    private GetInfoService getInfoService;

    @GetMapping(value = "/info")
    public HttpEntity<Map<String, List<String>>> getInfo(@RequestBody List<String> jiraNumbers) {
        log.info("HERERERE");
        if(CollectionUtils.isEmpty(jiraNumbers)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new HashMap<String, List<String>>());
        }

        Map<String, List<String>> body = getInfoService.getInfo(jiraNumbers);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
