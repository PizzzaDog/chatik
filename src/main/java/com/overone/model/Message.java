package com.overone.model;

public class Message {
    private Long id;
    private String time;
    private String sender;
    private String text;

    public Message(Long id, String time, String sender, String text) {
        this.id = id;
        this.time = time;
        this.sender = sender;
        this.text = text;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
