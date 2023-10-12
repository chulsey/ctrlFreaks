package com.codefest.ejcraft.model;

import java.io.Serializable;

/*
Lombok getter setter not working with jdk 21, using old-fashioned getter and setter for now
 */
public class Greeting implements Serializable {

    private String content;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String result;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
