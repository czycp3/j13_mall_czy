package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.Admin;
import com.cskaoyan.mall_springboot.bean.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.User;
import com.cskaoyan.mall_springboot.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author CZY-Y7000P
 */
@Controller
public class MainController {

    private MainService mainService;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @RequestMapping("/dashboard")
    @ResponseBody
    public BaseQueryVo dashboard(){
        return mainService.queryStatics();
    }


}
