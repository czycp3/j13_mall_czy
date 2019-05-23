package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.System;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-23 00:17
 */
@Mapper
public interface ConfigMapper {

    //查询配置信息
    List<System> searchByKeyName(@Param("searchValue") String searchValue);



    //修改配置信息
    void edit(@Param("keyName") String keyName, @Param("keyValue") String keyValue, @Param("updateTime") Date updateTime);
}
