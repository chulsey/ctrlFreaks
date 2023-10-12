package com.codefest.ejcraft.controller;

import com.codefest.ejcraft.api.ChangeRequestApi;
import com.codefest.ejcraft.api.model.ChangeRequest;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EJCRaftController implements ChangeRequestApi {
  @Override
  public ResponseEntity<ChangeRequest> startChangeRequest(List<String> requestBody) {
    ChangeRequest changeRequest = new ChangeRequest();
    changeRequest.setSummary("Stuff");
    changeRequest.setDescription("More stuff");

    return ResponseEntity.ok(changeRequest);
  }
}
