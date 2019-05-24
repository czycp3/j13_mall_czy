package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/24 0024 上午 9:17
 */
@Controller
public class LogController {
    @Autowired
    LogService service;

    @RequestMapping("/log/list")
    @ResponseBody
    public BaseQueryVo queryLogList(PageHelper pageHelper, String name){
        return service.queryLogList(pageHelper,name);
    }
}
