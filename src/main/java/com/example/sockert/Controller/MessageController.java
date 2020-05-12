package com.example.sockert.Controller;


import com.example.sockert.Model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MessageController {

    @MessageMapping("/chat")
    @SendTo("/topic/mes")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        System.out.println("send message " + chatMessage.getContent() + chatMessage.getSender());
        LocalTime time = LocalTime.now();

        ChatMessage chatMessage1 = new ChatMessage();
        chatMessage1.setContent(chatMessage.getContent());
        chatMessage1.setSender(chatMessage.getSender());
        chatMessage1.setTime(time);
        return chatMessage1;
    }


}


