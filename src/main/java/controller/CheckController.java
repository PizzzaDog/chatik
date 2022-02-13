package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CheckController {

    @GetMapping("/check")
    public ModelAndView checking(ModelAndView model) {
        String name = "FUUUUUUUUUU";
        model.setViewName("check");
        model.addObject("name", name);
        return model;

    }
}
