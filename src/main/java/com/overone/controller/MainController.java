package com.overone.controller;

import com.overone.model.Message;
import com.overone.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/hello")
    public ModelAndView hello() {
        return new ModelAndView("hello", "command", new Message());
    }

    @PostMapping("/chat")
    public ModelAndView chat(@RequestParam("sender") String sender) {
        ModelAndView chatModel = new ModelAndView("chat");
        chatModel.addObject("sender", sender);
        chatModel.addObject("allMessage", chatService.getAllMessage());
        return chatModel;
    }

    @PostMapping("/addMessage")
    public ModelAndView addMessage(@RequestParam("sender") String sender, @RequestParam(value = "text", required = false) String text) {
        boolean successInsert = chatService.addMessage(sender, text);
        ModelAndView model;
        if(successInsert) {
            model = new ModelAndView("chat");
            model.addObject("sender", sender);
            model.addObject("allMessage", chatService.getAllMessage());
            return model;
        }
        model = new ModelAndView("errorPage");
        model.addObject("errorMessage", "Error adding message");
        return model;
    }
}
