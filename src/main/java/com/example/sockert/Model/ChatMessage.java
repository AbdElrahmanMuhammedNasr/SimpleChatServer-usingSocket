package com.example.sockert.Model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table
@Data
public class ChatMessage {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String content;
    @Column
    private String sender;
//    @Column
//    private String recever;
    @Column
    private LocalTime time;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}