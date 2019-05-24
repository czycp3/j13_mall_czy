package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.Admin;
import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.ad.Ad;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.storage.Storage;
import com.cskaoyan.mall_springboot.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.swing.*;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/24 0024 上午 11:38
 */
@Controller
public class StorageController {
    @Autowired
    StorageService service;

    @RequestMapping("/storage/list")
    @ResponseBody
    public BaseQueryVo queryStorgeList(PageHelper pageHelper,String key,String name){
        return service.queryStorgeList(pageHelper,key,name);
    }

    @RequestMapping("/storage/update")
    @ResponseBody
    public SingleQueryVo updateStorage(@RequestBody Storage storage){
        return service.updateStorage(storage);
    }

    @RequestMapping("/storage/delete")
    @ResponseBody
    public SingleQueryVo deleteStorage(@RequestBody Storage storage){
        return service.deleteStorage(storage);
    }

}
