package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;

/**
 * @Author: zero
 * @Date: 2019/5/27 15:45
 * @Version 1.0
 */
public interface CatelogService {
    BaseResultVo getCatalogIndex();

    BaseResultVo getCurrentCatelogById(String id);
}
