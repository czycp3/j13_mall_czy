package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.goods.Goods;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.groupon.Groupon;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.mapper.GrouponMapper;
import com.cskaoyan.mall_springboot.mapper.GoodsMapper;
import com.cskaoyan.mall_springboot.service.GrouponService;
import com.cskaoyan.mall_springboot.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Service
public class GrouponServiceImpl implements GrouponService {

    private GrouponMapper grouponMapper;
    private GoodsMapper goodsMapper;

    @Autowired
    public GrouponServiceImpl(GrouponMapper grouponMapper, GoodsMapper goodsMapper) {
        this.grouponMapper = grouponMapper;
        this.goodsMapper = goodsMapper;
    }

    @Override
    public BaseQueryVo queryAllGrouponByPage(PageUtil pu, Groupon groupon) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<Groupon> resultVo = new ResultVo<>();
        String goodsId = groupon.getGoodsId();
        if (goodsId != null) {
            goodsId = "%" + goodsId + "%";
            groupon.setGoodsId(goodsId);
        }

        int total = grouponMapper.selectCountGroupon(groupon);
        pu.setOffset();

        List<Groupon> grouponList = grouponMapper.queryAllGrouponByPage(pu,groupon);

        resultVo.setItems(grouponList);
        resultVo.setTotal(total);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");

        baseQueryVo.setData(resultVo);
        return baseQueryVo;
    }


    @Override
    public SingleQueryVo updateGroupon(Groupon groupon) {
        SingleQueryVo<Groupon> singleQueryVo = new SingleQueryVo<>();
        try {
            int ret =  grouponMapper.updateByPrimaryKeySelective(groupon);
            if(ret != 0){
                Groupon groupon1 = grouponMapper.selectByPrimaryKey(groupon.getId());
                singleQueryVo.setData(groupon1);
                singleQueryVo.setErrmsg("成功");
                singleQueryVo.setErrno(0);
            }
        }catch (Exception e){
            singleQueryVo.setErrmsg("更新失败");
            throw new RuntimeException(e);
        }
        return singleQueryVo;
    }

    @Override
    public SingleQueryVo deleteGroupon(Groupon groupon) {
        SingleQueryVo<Groupon> singleQueryVo = new SingleQueryVo<>();
        try {
            groupon.setDeleted(1);
            int ret = grouponMapper.updateByPrimaryKeySelective(groupon);
            if(ret == 1) {
                singleQueryVo.setErrmsg("成功");
                singleQueryVo.setErrno(0);
            }
        }catch (Exception e){
            singleQueryVo.setErrmsg("删除失败");
            throw new RuntimeException(e);
        }
        return singleQueryVo;
    }

    @Override
    public SingleQueryVo create(Groupon groupon) {
        SingleQueryVo<Groupon> singleQueryVo = new SingleQueryVo<>();
        try {
            Goods goods = goodsMapper.selectGoodsById(groupon.getGoodsId());
            groupon.setGoodsName(goods.getName());
            groupon.setPicUrl(goods.getPicUrl());
            int ret = grouponMapper.insertSelective(groupon);
            if(ret == 1) {
                singleQueryVo.setErrmsg("成功");
                singleQueryVo.setErrno(0);
                singleQueryVo.setData(groupon);
            }
        }catch (Exception e){
            singleQueryVo.setErrmsg("参数错误！");
            singleQueryVo.setErrno(402);
            throw new RuntimeException(e);
        }
        return singleQueryVo;
    }

}
