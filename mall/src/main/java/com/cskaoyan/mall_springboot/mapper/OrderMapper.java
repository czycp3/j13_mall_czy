package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.mallmg.Order;
import com.cskaoyan.mall_springboot.bean.mallmg.OrderGoods;
import com.cskaoyan.mall_springboot.bean.mallmg.OrderUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface OrderMapper {
    Integer SelectOrderCount();
    ArrayList<Order> SelectOrderPage(@Param("pageHelper") MallPageHelper mallPageHelper, @Param("offset") int offset);

    Order SelectOrderById(@Param("id") Integer id);

    ArrayList<OrderGoods> SelectOrderGoodsById(@Param("orderId") Integer id);

    OrderUser SelectUserById(@Param("id") Integer id);
}
