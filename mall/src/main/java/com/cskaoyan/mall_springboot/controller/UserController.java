package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.User;
import com.cskaoyan.mall_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author CZY-Y7000P
 */
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(User user, Model model){
        boolean login = userService.login(user);
        if(login){
            model.addAttribute("user",user);
            return "hello";
        }
        return "index.html";
    }
}
