package com.overone.service;

import com.overone.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.overone.repository.MessageRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessage(){
        return messageRepository.findAll();
    }

    public boolean addMessage(String sender, String text) {
        if (text == null || text.isEmpty()) return false;
        Message message = new Message();
        message.setSender(sender);
        message.setText(text);
        String time = LocalDateTime.now().toString();
        message.setTime(time.substring(11, 19));
        return messageRepository.save(message);
    }
}
