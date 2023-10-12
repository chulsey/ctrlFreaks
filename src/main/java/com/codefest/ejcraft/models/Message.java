package com.codefest.ejcraft.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Message {

  private String role;
  private String content;

  public Message(String role, String content) {
    this.role = role;
    this.content = content;
  }
}
