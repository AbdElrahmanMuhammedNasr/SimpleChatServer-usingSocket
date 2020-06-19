package com.example.sockert.Controller;


import com.example.sockert.Model.ChatMessage;
import com.example.sockert.Repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class MessageController {

    @Autowired
    private MessageRepo messageRepo;

    @MessageMapping("/chat")
    @SendTo("/topic/mes")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
//        System.out.println("send message " + chatMessage.getContent() + chatMessage.getSender());
        LocalTime time = LocalTime.now();
        ChatMessage chatMessage1 = new ChatMessage();
        chatMessage1.setContent(chatMessage.getContent());
        chatMessage1.setSender(chatMessage.getSender());
        chatMessage1.setTime(time);
        messageRepo.save(chatMessage1);
        return chatMessage1;
    }

    @GetMapping(value = "/getAll")
    public List<ChatMessage> getAll(){
        return messageRepo.findAll();
    }


}


