package com.cskaoyan.mall_springboot.mapper.goodsmapper;

import com.cskaoyan.mall_springboot.bean.goods.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/22 22:17
 * @Version 1.0
 */

public interface GoodsMapper {
    List<Goods> selectGoodsList();
}
