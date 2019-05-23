package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.mallmg.Region;
import com.cskaoyan.mall_springboot.bean.mallmg.ReturnMallT;

public interface RegionService {
    ReturnMallT<Region> selectAllRegion();
}
