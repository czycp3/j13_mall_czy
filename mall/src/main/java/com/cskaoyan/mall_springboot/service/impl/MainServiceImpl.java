package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.coupon.Coupon;
import com.cskaoyan.mall_springboot.bean.goods.Goods;
import com.cskaoyan.mall_springboot.bean.mallmg.Brand;
import com.cskaoyan.mall_springboot.bean.mallmg.Category;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.WxQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.WxResultVo;
import com.cskaoyan.mall_springboot.bean.topic.Topic;
import com.cskaoyan.mall_springboot.bean.wx.FloorGoodsList;
import com.cskaoyan.mall_springboot.bean.wx.GrouponList;
import com.cskaoyan.mall_springboot.mapper.*;
import com.cskaoyan.mall_springboot.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Service
public class MainServiceImpl implements MainService {

    private MainMapper mainMapper;
    private GoodsMapper goodsMapper;
    private BrandMapper brandMapper;
    private TopicMapper topicMapper;
    private CategoryMapper categoryMapper;
    private CouponMapper couponMapper;
    private GrouponMapper grouponMapper;

    @Autowired
    public MainServiceImpl(MainMapper mainMapper, GoodsMapper goodsMapper, BrandMapper brandMapper, TopicMapper topicMapper, CategoryMapper categoryMapper, CouponMapper couponMapper, GrouponMapper grouponMapper) {
        this.mainMapper = mainMapper;
        this.goodsMapper = goodsMapper;
        this.brandMapper = brandMapper;
        this.topicMapper = topicMapper;
        this.categoryMapper = categoryMapper;
        this.couponMapper = couponMapper;
        this.grouponMapper = grouponMapper;
    }


    @Override
    public BaseQueryVo queryStatics() {
        int goodsTotal = mainMapper.queryGoodsTotal();
        int orderTotal = mainMapper.queryOrderTotal();
        int productTotal = mainMapper.queryProductTotal();
        int userTotal = mainMapper.queryUserTotal();
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo resultVo = new ResultVo();
        resultVo.setGoodsTotal(goodsTotal);
        resultVo.setOrderTotal(orderTotal);
        resultVo.setProductTotal(productTotal);
        resultVo.setUserTotal(userTotal);
        baseQueryVo.setData(resultVo);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");

        return baseQueryVo;
    }

    @Override
    public WxQueryVo queryMainInfo() {
        WxQueryVo wxQueryVo = new WxQueryVo();
        WxResultVo wxResultVo = new WxResultVo();

        List<Goods> hotGoodsList = goodsMapper.queryHotGoods();
        wxResultVo.setHotGoodsList(hotGoodsList);
        List<Brand> brandList = brandMapper.queryBrandList();
        wxResultVo.setBrandList(brandList);
        List<Topic> topicList = topicMapper.queryAllTopic();
        wxResultVo.setTopicList(topicList);
        List<Goods> newGoodsList = goodsMapper.queryNewGoods();
        wxResultVo.setNewGoodsList(newGoodsList);
        List<FloorGoodsList> floorGoodsList = categoryMapper.queryCategory();
        wxResultVo.setFloorGoodsList(floorGoodsList);
        List<Coupon> couponList = couponMapper.queryCoupon();
        wxResultVo.setCouponList(couponList);
        List<GrouponList> grouponList = grouponMapper.queryGroupon();
        wxResultVo.setGrouponList(grouponList);

        wxQueryVo.setData(wxResultVo);
        wxQueryVo.setErrmsg("成功");
        wxQueryVo.setErrno(0);
        return wxQueryVo;
    }
}
