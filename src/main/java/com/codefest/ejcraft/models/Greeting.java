package com.codefest.ejcraft.models;

import java.io.Serializable;
import java.util.List;

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
