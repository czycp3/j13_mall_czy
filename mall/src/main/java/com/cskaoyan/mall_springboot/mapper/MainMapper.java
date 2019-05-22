package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.Admin;
import com.cskaoyan.mall_springboot.bean.BaseQueryVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author CZY-Y7000P
 */
public interface MainMapper {
    int queryGoodsTotal();
    int queryOrderTotal();
    int queryProductTotal();
    int queryUserTotal();

    Admin queryAdmin(@Param("admin") Admin admin);
}
