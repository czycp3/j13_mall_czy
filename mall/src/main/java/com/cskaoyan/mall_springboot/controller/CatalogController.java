package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;
import com.cskaoyan.mall_springboot.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zero
 * @Date: 2019/5/27 15:38
 * @Version 1.0
 */
@Controller
@RequestMapping("/wx")
public class CatalogController {
    @Autowired
    CatelogService catelogService;

    @RequestMapping("catalog/index")
    @ResponseBody
    public BaseResultVo catalogIndex(){
        BaseResultVo baseResultVo = catelogService.getCatalogIndex();
        return baseResultVo;
    }

    @RequestMapping("catalog/current")
    @ResponseBody
    public BaseResultVo getCurrentCatelogById(String id){
        return catelogService.getCurrentCatelogById(id);
    }
}
