package com.codefest.ejcraft.models.pojo;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class Issuerestriction {

  private Issuerestrictions issuerestrictions;
  private Boolean shouldDisplay;
  private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

  public Issuerestrictions getIssuerestrictions() {
    return issuerestrictions;
  }

  public void setIssuerestrictions(Issuerestrictions issuerestrictions) {
    this.issuerestrictions = issuerestrictions;
  }

  public Boolean getShouldDisplay() {
    return shouldDisplay;
  }

  public void setShouldDisplay(Boolean shouldDisplay) {
    this.shouldDisplay = shouldDisplay;
  }

  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
