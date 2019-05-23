package com.cskaoyan.mall_springboot.service.managementmall;

import com.cskaoyan.mall_springboot.bean.managementmall.Region;
import com.cskaoyan.mall_springboot.bean.managementmall.ReturnMallT;

public interface RegionService {
    ReturnMallT<Region> selectAllRegion();
}
