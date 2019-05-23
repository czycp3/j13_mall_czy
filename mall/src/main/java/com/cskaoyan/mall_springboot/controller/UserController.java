package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.User;
import com.cskaoyan.mall_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cly
 */
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/user/list")
    public String list(User user, Model model){

        return "index.html";
    }
}
