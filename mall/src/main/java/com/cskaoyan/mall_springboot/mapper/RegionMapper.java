package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.mallmg.Region;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegionMapper {
    List<Region> selectAllRegion();
}
