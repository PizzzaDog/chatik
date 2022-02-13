package by.overone.controller;

import by.overone.MessageService;
import by.overone.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import by.overone.repository.MessageRepository;

import java.util.List;

@Controller
public class MessageController {
    private MessageRepository messageRepository = new MessageRepository();

    @Autowired
    private MessageService messageService;

    @GetMapping("/messages")
    public ModelAndView getAllMessages(ModelAndView model) {
        model.setViewName("messages");
        List<Message> all = messageRepository.getAll();
        model.addObject("messages", all);
        return model;
    }

    @PostMapping("/messages")
    public ModelAndView refreshMethod(@RequestParam("username") String username, @RequestParam(value = "text", required = false) String text) {
        ModelAndView model = new ModelAndView("messages");
        if (text != null) {
            messageService.addMessage(username, text);
        }
        model.addObject("username", username);
        model.addObject("messages", messageRepository.getAll());
        return model;
    }
}
