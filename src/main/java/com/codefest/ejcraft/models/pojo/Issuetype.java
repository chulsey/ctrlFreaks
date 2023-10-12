package com.codefest.ejcraft.models.pojo;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Issuetype {

  private String self;
  private String id;
  private String description;
  private String iconUrl;
  private String name;
  private Boolean subtask;
  private Integer avatarId;
  private String entityId;
  private Integer hierarchyLevel;
  private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

  public String getSelf() {
    return self;
  }

  public void setSelf(String self) {
    this.self = self;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getIconUrl() {
    return iconUrl;
  }

  public void setIconUrl(String iconUrl) {
    this.iconUrl = iconUrl;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getSubtask() {
    return subtask;
  }

  public void setSubtask(Boolean subtask) {
    this.subtask = subtask;
  }

  public Integer getAvatarId() {
    return avatarId;
  }

  public void setAvatarId(Integer avatarId) {
    this.avatarId = avatarId;
  }

  public String getEntityId() {
    return entityId;
  }

  public void setEntityId(String entityId) {
    this.entityId = entityId;
  }

  public Integer getHierarchyLevel() {
    return hierarchyLevel;
  }

  public void setHierarchyLevel(Integer hierarchyLevel) {
    this.hierarchyLevel = hierarchyLevel;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
