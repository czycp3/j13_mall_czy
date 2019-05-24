package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.mapper.StatMapper;
import com.cskaoyan.mall_springboot.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: 頽小废
 * @Date: 2019/5/23 20:50
 * @Compony: http://www.tuixiaofei.com
 */

@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private StatMapper statMapper;

    /**
     * 获取用户数据
     * @return
     */
    @Override
    public List<Map> searchUserRows() {
        return statMapper.searchUserRows();
    }

    /**
     * 获取订单数据
     * @return
     */
    @Override
    public List<Map> searchOrderRows() {
        return statMapper.searchOrderRows();
    }


    /**
     * 获取商品数据
     * @return
     */
    @Override
    public List<Map> searchGoodsStat() {
        return statMapper.searchGoodsRows();
    }
}
