package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.mallmg.Order;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;

import java.util.ArrayList;
import java.util.HashMap;

public interface OrderService {
    BaseQueryVo<Order> SelectOrderPage(MallPageHelper mallPageHelper);

    SingleQueryVo<HashMap> SelectOrderDetail(Integer id);
}
