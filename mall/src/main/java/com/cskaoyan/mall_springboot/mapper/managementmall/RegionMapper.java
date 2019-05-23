package com.cskaoyan.mall_springboot.mapper.managementmall;

import com.cskaoyan.mall_springboot.bean.managementmall.Region;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegionMapper {
    List<Region> selectAllRegion();
}
