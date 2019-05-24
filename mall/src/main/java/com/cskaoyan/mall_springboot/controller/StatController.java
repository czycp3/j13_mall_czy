package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.Stat.Statdata;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.service.StatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @Author: 頽小废
 * @Date: 2019/5/23 10:16
 * @Compony: http://www.tuixiaofei.com
 */

@Controller
public class StatController {

    @Autowired
    private StatService statService;

    /**
     * 用户统计
     * @return
     */
    @RequestMapping("stat/user")
    @ResponseBody
    public SingleQueryVo<Object> userStat(){
        SingleQueryVo<Object> queryVo = new SingleQueryVo<>();
        Statdata data = new Statdata();
        String[] columns = {"day","users"};
        List<Map> rows = statService.searchUserRows();
        data.setColumns(columns);
        data.setRows(rows);
        queryVo.setData(data);
        queryVo.setErrmsg("成功");
        queryVo.setErrno(0);
        return queryVo;
    }

    /**
     * 订单统计
     * @return
     */
    @RequestMapping("stat/order")
    @ResponseBody
    public SingleQueryVo<Object> orderStat(){
        SingleQueryVo<Object> queryVo = new SingleQueryVo<>();
        Statdata data = new Statdata();
        String[] columns = {"day","orders","customers","amount","pcr"};
        List<Map> rows = statService.searchOrderRows();
        data.setColumns(columns);
        data.setRows(rows);
        queryVo.setData(data);
        queryVo.setErrno(0);
        queryVo.setErrmsg("成功");
        return queryVo;
    }

    /**
     * 商品统计
     * @return
     */
    @RequestMapping("stat/goods")
    @ResponseBody
    public SingleQueryVo<Object> goodsStat(){
        SingleQueryVo<Object> queryVo = new SingleQueryVo<>();
        Statdata data = new Statdata();
        String[] columns = {"day", "orders", "products", "amount"};
        List<Map> rows = statService.searchGoodsStat();
        data.setColumns(columns);
        data.setRows(rows);
        queryVo.setErrmsg("成功");
        queryVo.setErrno(0);
        queryVo.setData(data);
        return queryVo;
    }
}
