package com.cskaoyan.mall_springboot.service.goodsservice;

import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;
import com.cskaoyan.mall_springboot.bean.goods.Data;
import com.cskaoyan.mall_springboot.bean.goods.Goods;

/**
 * @Author: zero
 * @Date: 2019/5/22 22:15
 * @Version 1.0
 */
public interface GoodsService {

    BaseResultVo selectGoodsList(int page, int limit,String goodsSn,String name, String sort, String order);
    /**
     *@Param  id 商品id
     *@Return   该商品id对应的商品类json对象
     *@OtherMsg
     */
    BaseResultVo selectGoodsById(String id);

    BaseResultVo selectCatAndBrand();

    BaseResultVo updateGoods(Data baseResultVo);

    BaseResultVo deleteGoods(Goods goods);
}
