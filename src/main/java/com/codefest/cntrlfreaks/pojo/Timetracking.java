package com.codefest.cntrlfreaks.pojo;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;


@Generated("jsonschema2pojo")
public class Timetracking {

    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}