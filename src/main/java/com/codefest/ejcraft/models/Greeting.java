package com.codefest.ejcraft.models;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Greeting implements Serializable {

  private String content;

  private String summary;

  private String description;
}
