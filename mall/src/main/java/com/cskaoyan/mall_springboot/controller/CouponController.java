package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.coupon.Coupon;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.service.CouponService;
import com.cskaoyan.mall_springboot.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CZY-Y7000P
 */
@Controller
public class CouponController {

    private CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @RequestMapping("/coupon/list")
    @ResponseBody
    public BaseQueryVo list(PageUtil pu, Coupon coupon){
        return couponService.queryAllCouponByPage(pu,coupon);
    }

    @RequestMapping("/coupon/update")
    @ResponseBody
    public SingleQueryVo update(@RequestBody Coupon coupon){
        return couponService.updateCoupon(coupon);
    }

    @RequestMapping("/coupon/delete")
    @ResponseBody
    public SingleQueryVo delete(@RequestBody Coupon coupon){
        return couponService.deleteCoupon(coupon);
    }

    @RequestMapping("/coupon/create")
    @ResponseBody
    public SingleQueryVo create(@RequestBody Coupon coupon) {
        return couponService.create(coupon);
    }
}
