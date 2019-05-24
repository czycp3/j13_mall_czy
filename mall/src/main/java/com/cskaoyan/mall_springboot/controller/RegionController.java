package com.cskaoyan.mall_springboot.controller;

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
    @RequestMapping("/list")
    public ReturnMallT<Region> regionList(){
        ReturnMallT<Region> returnMallT=regionService.selectAllRegion();
        return returnMallT;
    }
}
