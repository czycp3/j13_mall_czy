package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.Admin;
import com.cskaoyan.mall_springboot.bean.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.ResultVo;
import com.cskaoyan.mall_springboot.mapper.MainMapper;
import com.cskaoyan.mall_springboot.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CZY-Y7000P
 */
@Service
public class MainServiceImpl implements MainService {

    private MainMapper mainMapper;

    @Autowired
    public MainServiceImpl(MainMapper mainMapper) {
        this.mainMapper = mainMapper;
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
}
