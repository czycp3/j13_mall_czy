package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.mallmg.Category;
import com.cskaoyan.mall_springboot.bean.mallmg.Region;
import com.cskaoyan.mall_springboot.bean.mallmg.ReturnMallT;
import com.cskaoyan.mall_springboot.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    RegionService regionService;
    ReturnMallT<Region> returnMallT;
    @RequestMapping("/list")
    public ReturnMallT<Region> regionList(){
        if (returnMallT!=null&&returnMallT.getData().size()>0&&returnMallT.getData().get(0) instanceof Region){
            return returnMallT;
        }
        returnMallT=regionService.selectAllRegion();
        return returnMallT;
    }
}
