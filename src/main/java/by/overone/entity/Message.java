package by.overone.entity;

import org.springframework.stereotype.Component;

@Component
public class Message {
    private Integer id;
    private String time;
    private String sender;
    private String text;

    public Message() {
    }

    public Message(Integer id, String time, String sender, String text) {
        this.id = id;
        this.time = time;
        this.sender = sender;
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
