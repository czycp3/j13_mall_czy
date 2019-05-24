package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;
import com.cskaoyan.mall_springboot.bean.goods.Data;
import com.cskaoyan.mall_springboot.bean.goods.Goods;
import com.cskaoyan.mall_springboot.service.goodsservice.GoodsService;
import com.cskaoyan.mall_springboot.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zero
 * @Date: 2019/5/22 21:55
 * @Version 1.0
 */
@Controller
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @RequestMapping("/goods/list")
    @ResponseBody
    public BaseResultVo selectGoodsList(int page,int limit,String sort,String order,String goodsSn,String name){
        BaseResultVo baseResultVo = goodsService.selectGoodsList(page,limit,sort,order,goodsSn,name);
        return baseResultVo;
    }
    @RequestMapping("/goods/detail")
    @ResponseBody
    public BaseResultVo selectGoodsById(@RequestParam String id){
        BaseResultVo baseResultVo = goodsService.selectGoodsById(id);
        return baseResultVo;
    }

    @RequestMapping("/goods/catAndBrand")
    @ResponseBody
    public BaseResultVo selectCatAndBrand(){
        BaseResultVo baseResultVo = goodsService.selectCatAndBrand();
        return baseResultVo;
    }

    @RequestMapping("/goods/update")
    @ResponseBody
    public BaseResultVo updateGoods(@RequestBody Data data){
        BaseResultVo resultVo = goodsService.updateGoods(data);
        return resultVo;
    }

    @RequestMapping("/goods/delete")
    @ResponseBody
    public BaseResultVo deleteGoods(@RequestBody Goods goods){
        BaseResultVo baseResultVo = goodsService.deleteGoods(goods);
        return baseResultVo;
    }
}
