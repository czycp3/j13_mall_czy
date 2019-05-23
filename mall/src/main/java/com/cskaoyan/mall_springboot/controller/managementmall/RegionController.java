package com.cskaoyan.mall_springboot.controller.managementmall;

import com.cskaoyan.mall_springboot.bean.managementmall.Region;
import com.cskaoyan.mall_springboot.bean.managementmall.ReturnMallT;
import com.cskaoyan.mall_springboot.service.managementmall.RegionService;
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
