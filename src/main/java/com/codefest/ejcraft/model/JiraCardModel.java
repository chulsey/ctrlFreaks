package com.codefest.ejcraft.model;

import java.io.Serializable;

/*
Lombok getter setter not working with jdk 21, using old-fashioned getter and setter for now
 */
public class JiraCardModel implements Serializable {

    private String jiraInput;

    public String getJiraInput() {
        return jiraInput;
    }

    public void setJiraInput(String jiraInput) {
        this.jiraInput = jiraInput;
    }

}
