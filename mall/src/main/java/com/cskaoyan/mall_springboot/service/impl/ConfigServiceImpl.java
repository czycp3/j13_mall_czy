package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.System;
import com.cskaoyan.mall_springboot.mapper.ConfigMapper;
import com.cskaoyan.mall_springboot.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-22 23:27
 */
@Service
public class ConfigServiceImpl implements ConfigService {
    @Autowired
    ConfigMapper configMapper;


    /**
     * 根据传入的信息查找
     * @param searchValue
     * @return
     */

    @Override
    public List<System> searchByKeyName(String searchValue) {
        return configMapper.searchByKeyName(searchValue);
    }

    @Override
    public void edit(String keyName, String keyValue) {
        Date  updateTime = new Date();
        configMapper.edit(keyName,keyValue,updateTime);
    }
}
