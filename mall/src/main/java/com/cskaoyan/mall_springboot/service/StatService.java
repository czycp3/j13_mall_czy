package com.cskaoyan.mall_springboot.service;


import java.util.List;
import java.util.Map;

/**
 * @Author: 頽小废
 * @Date: 2019/5/23 20:48
 * @Compony: http://www.tuixiaofei.com
 */

public interface StatService {

    /**
     * 获取用户数据
     * @return
     */
    List<Map> searchUserRows();

    /**
     * 获取订单数据
     * @return
     */
    List<Map> searchOrderRows();

    /**
     * 获取商品数据
     * @return
     */
    List<Map> searchGoodsStat();
}
