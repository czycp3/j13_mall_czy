package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.System;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-22 23:27
 */
public interface ConfigService {
    //查找配置
    List<System> searchByKeyName(String searchValue);
    //修改配置
    void edit(String keyName, String keyValue);
}
