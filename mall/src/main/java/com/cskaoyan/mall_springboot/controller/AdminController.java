package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.service.AdminService;
import com.cskaoyan.mall_springboot.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/23 0023 下午 3:10
 */
@Controller
public class AdminController {
    @Autowired
    AdminService service;

    @RequestMapping("/admin/list")
    @ResponseBody
    public BaseQueryVo adminList(PageHelper pageHelper,String username){
        return service.queryAdminList(pageHelper,username);
    }
}
