package com.cskaoyan.mall_springboot.service.goodsservice.impl;

import com.cskaoyan.mall_springboot.bean.goods.*;
import com.cskaoyan.mall_springboot.mapper.goodsmapper.GoodsMapper;
import com.cskaoyan.mall_springboot.service.goodsservice.GoodsService;
import com.cskaoyan.mall_springboot.util.PageUtil;
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
    public BaseResultVo selectGoodsList(int page,int limit,String sort,String order) {
        int total = goodsMapper.selectTotal();
        limit=total<limit?total:limit;
        int offset = (page-1)*(limit);
        List<Goods> goodsList = goodsMapper.selectGoodsListByPage(limit,offset,sort,order);
        return GoodsServiceImpl.packaging(goodsList);
    }
    @Override
    public BaseResultVo selectGoodsById(String id) {
        Goods goods = goodsMapper.selectGoodsById(id);
        List<Attribute> attributes = goodsMapper.selectAttributeById(id);
        List<Specification> specifications = goodsMapper.selectSpecificationById(id);
        List<Product> products = goodsMapper.selectProductById(id);

        Data<Object> data = new Data<>();
        data.setGoods(goods);
        data.setAttributes(attributes);
        data.setSpecifications(specifications);
        data.setProducts(products);

        int pid = goodsMapper.selectCategoryPidById(data.getGoods().getCategoryId());
        int[] categoryIds = {data.getGoods().getCategoryId(), pid};
        data.setCategoryIds(categoryIds);

        BaseResultVo baseResultVo =new BaseResultVo();
        baseResultVo.setErrno(0);
        baseResultVo.setData(data);
        baseResultVo.setErrmsg("成功");
        return baseResultVo;
    }

    private static BaseResultVo packaging(List<Goods> goodsList) {
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
