package com.cskaoyan.mall_springboot.service.goodsservice.impl;

import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;
import com.cskaoyan.mall_springboot.bean.goods.Data;
import com.cskaoyan.mall_springboot.bean.goods.Goods;
import com.cskaoyan.mall_springboot.mapper.goodsmapper.GoodsMapper;
import com.cskaoyan.mall_springboot.service.goodsservice.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/22 22:16
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public BaseResultVo selectGoodsList() {
        List<Goods> goodsList = goodsMapper.selectGoodsList();
        for (Goods goods:goodsList) {
            String[] gallery = goods.getGallerys().split(",");
            goods.setGallery(gallery);
        }

        BaseResultVo baseResultVo =new BaseResultVo();
        Data<Goods> goodsData = new Data<>();

        goodsData.setItems(goodsList);
        goodsData.setTotal(goodsList.size());

        baseResultVo.setErrno(0);
        baseResultVo.setData(goodsData);
        baseResultVo.setErrmsg("成功");
        return baseResultVo;
    }
}
