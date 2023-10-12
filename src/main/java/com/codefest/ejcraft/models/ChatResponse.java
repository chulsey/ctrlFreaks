package com.codefest.ejcraft.models;

import java.util.List;
import lombok.Data;

@Data
public class ChatResponse {

  private List<Choice> choices;

  @Data
  public static class Choice {

    private int index;
    private Message message;
  }
}
