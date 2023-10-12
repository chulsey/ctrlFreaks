package com.codefest.cntrlfreaks.pojo;

import javax.annotation.processing.Generated;
import java.util.LinkedHashMap;
import java.util.Map;


@Generated("jsonschema2pojo")
public class Customfield10018 {

    private Boolean hasEpicLinkFieldDependency;
    private Boolean showField;
    private NonEditableReason nonEditableReason;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Boolean getHasEpicLinkFieldDependency() {
        return hasEpicLinkFieldDependency;
    }

    public void setHasEpicLinkFieldDependency(Boolean hasEpicLinkFieldDependency) {
        this.hasEpicLinkFieldDependency = hasEpicLinkFieldDependency;
    }

    public Boolean getShowField() {
        return showField;
    }

    public void setShowField(Boolean showField) {
        this.showField = showField;
    }

    public NonEditableReason getNonEditableReason() {
        return nonEditableReason;
    }

    public void setNonEditableReason(NonEditableReason nonEditableReason) {
        this.nonEditableReason = nonEditableReason;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
