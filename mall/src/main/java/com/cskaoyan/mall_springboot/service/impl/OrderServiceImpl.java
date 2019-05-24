package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.mallmg.Order;
import com.cskaoyan.mall_springboot.bean.mallmg.OrderGoods;
import com.cskaoyan.mall_springboot.bean.mallmg.OrderUser;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.mapper.OrderMapper;
import com.cskaoyan.mall_springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Override
    public BaseQueryVo<Order> SelectOrderPage(MallPageHelper mallPageHelper) {
        int offset = mallPageHelper.getOffset();
        Integer integer = orderMapper.SelectOrderCount();
        ArrayList<Order> orders = orderMapper.SelectOrderPage(mallPageHelper,offset);
        ResultVo<Order> orderResultVo = new ResultVo<>();
        BaseQueryVo<Order> orderBaseQueryVo = new BaseQueryVo<>();
        orderResultVo.setTotal(integer);
        orderResultVo.setItems(orders);
        orderBaseQueryVo.setData(orderResultVo);
        orderBaseQueryVo.setErrno(0);
        orderBaseQueryVo.setErrmsg("成功");
        return orderBaseQueryVo;
    }

    @Override
    public SingleQueryVo<HashMap> SelectOrderDetail(Integer id) {
        SingleQueryVo<HashMap> singleQueryVo = new SingleQueryVo<>();
        HashMap<Object, Object> hashMap = new HashMap<>();
        Order order =  orderMapper.SelectOrderById(id);
       ArrayList<OrderGoods> orderGoods = orderMapper.SelectOrderGoodsById(order.getId());
       OrderUser orderUser = orderMapper.SelectUserById(order.getUserId());
       hashMap.put("order",order);
       hashMap.put("orderGoods",orderGoods);
       hashMap.put("user",orderUser);
       singleQueryVo.setData(hashMap);
       singleQueryVo.setErrmsg("成功");
       singleQueryVo.setErrno(0);
        return singleQueryVo;
    }
}
