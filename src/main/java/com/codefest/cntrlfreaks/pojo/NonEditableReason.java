package com.codefest.cntrlfreaks.pojo;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;


@Generated("jsonschema2pojo")
public class NonEditableReason {

    private String reason;
    private String message;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}