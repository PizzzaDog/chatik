package com.overone.service;

import com.overone.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.overone.repository.MessageRepository;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAllMessage(){
        return messageRepository.findAll();
    }

}
