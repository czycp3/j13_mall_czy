package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.BaseQueryVo;
import com.cskaoyan.mall_springboot.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CZY-Y7000P
 */
@Controller
public class AdController {
    private AdService adService;

    @Autowired
    public AdController(AdService adService) {
        this.adService = adService;
    }

    @RequestMapping("/ad/list")
    @ResponseBody
    public BaseQueryVo list(int page,int limit,String sort,String order){
        return adService.queryAllAdByPage(page,limit,sort,order);
    }
}
