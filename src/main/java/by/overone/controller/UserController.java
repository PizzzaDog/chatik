package by.overone.controller;

import by.overone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/userCheck")
    public ModelAndView redirectUserByUsername(ModelAndView model, String username, @RequestParam String redirectUrl) {
        if(model.getModel().get("isLogin").toString().equals("true")) return model;
        model.addObject("username", username);
        if (userService.userExistByUsername(username) ) {
            model.addObject("redirect", redirectUrl);
            model.setViewName("check_pass");
            return model;



        }

        model.setViewName("register");
        return model;
    }

    @PostMapping("/register")
    public ModelAndView register(@RequestParam String redirectUrl, @RequestParam String username) {
        ModelAndView model = new ModelAndView();
        model.addObject("userna");
        return model;
    }
    @PostMapping("/checkCreds")
    public ModelAndView checkCreds(@RequestParam String redirect, @RequestParam String username, @RequestParam String password) {
        ModelAndView model = new ModelAndView();
        if (userService.checkCreds(username, password)) {
            model.setViewName(redirect);
        }
        return model;
    }

}
