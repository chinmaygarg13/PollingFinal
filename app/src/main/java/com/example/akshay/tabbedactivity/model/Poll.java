package com.example.akshay.tabbedactivity.model;

import java.util.List;

public class Poll {

    public Poll(String groupName, String question, List<String> options, String timestamp, String expiryDate) {
        this.groupName = groupName;
        this.question = question;
        this.options = options;
        this.timestamp = timestamp;
        this.expiryDate = expiryDate;
    }

    private String groupName;
    private String question;
    private List<String> options;
    private String timestamp;
    private String expiryDate;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
