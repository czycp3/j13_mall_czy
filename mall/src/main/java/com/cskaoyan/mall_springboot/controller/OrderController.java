package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.mallmg.Order;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @RequestMapping("/list")
    public BaseQueryVo<Order> SelectOrderPage( MallPageHelper mallPageHelper){
        BaseQueryVo<Order> orderBaseQueryVo = orderService.SelectOrderPage(mallPageHelper);
        return orderBaseQueryVo;
    }
    @RequestMapping("/detail")
    public SingleQueryVo<HashMap> SelectOrderDetail(Integer id){
        SingleQueryVo<HashMap> singleQueryVo=orderService.SelectOrderDetail(id);
        return singleQueryVo;
    }
}
