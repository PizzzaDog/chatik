package com.overone.controller;

import com.overone.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.overone.service.ChatService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/hello")
    public ModelAndView hello() {
        return new ModelAndView("hello", "command", new Message());
    }

//    @PostMapping("/chat")
//    public ModelAndView chat(@ModelAttribute("dispatcher") Message message,
//                             ModelAndView model){
//
//        List<Message> allMessage = chatService.getAllMessage();
//
//        model.setViewName("chat");
//        model.addObject("allMessage",allMessage);
//        model.addObject("sender", message.getSender());
//        return model;
//    }
@PostMapping("/chat")
public String chat(@ModelAttribute("dispatcher") Message message,
                         ModelMap model){

    List<Message> allMessage = chatService.getAllMessage();

    model.addAttribute("allMessage", allMessage);
    model.addAttribute("sender", message.getSender());

    return "chat";
}
    @PostMapping("/addMessage")
    public String addMessage(@ModelAttribute("dispatcher") Message message,
                       ModelMap model){

     //   List<Message> allMessage = chatService.getAllMessage();

      //  model.addAttribute("allMessage", allMessage);
        model.addAttribute("sender", message.getSender());

        return "chat";
    }



//    public String addStudent(@ModelAttribute("mvc-dispatcher") Developer developer,
//                             ModelMap model) {
//        model.addAttribute("id", developer.getId());
//        model.addAttribute("name", developer.getName());
//        model.addAttribute("specilaty", developer.getSpecialty());
//        model.addAttribute("experience", developer.getExperience());
//
//        return "result";
//    }

//    @GetMapping("/check")
//    public ModelAndView checking(ModelAndView model) {
//        String name = "FUUUUUUUUUU";
//        model.setViewName("check");
//        model.addObject("name", name);
//        return model;
//
//    }
}
