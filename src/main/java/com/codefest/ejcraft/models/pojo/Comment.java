package com.codefest.ejcraft.models.pojo;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Comment {

  private List<Object> comments;
  private String self;
  private Integer maxResults;
  private Integer total;
  private Integer startAt;
  private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

  public List<Object> getComments() {
    return comments;
  }

  public void setComments(List<Object> comments) {
    this.comments = comments;
  }

  public String getSelf() {
    return self;
  }

  public void setSelf(String self) {
    this.self = self;
  }

  public Integer getMaxResults() {
    return maxResults;
  }

  public void setMaxResults(Integer maxResults) {
    this.maxResults = maxResults;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public Integer getStartAt() {
    return startAt;
  }

  public void setStartAt(Integer startAt) {
    this.startAt = startAt;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
