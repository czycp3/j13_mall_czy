package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.coupon.Coupon;
import com.cskaoyan.mall_springboot.bean.coupon.CouponUser;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.util.PageUtil;

/**
 * @author CZY-Y7000P
 */
public interface CouponService {
    /**
     * 分页查询优惠券
     * @param pu
     * @param coupon
     * @return BaseQueryVo
     */
    BaseQueryVo queryAllCouponByPage(PageUtil pu, Coupon coupon);

    /**
     * 更新优惠券
     * @param coupon
     * @return SingleQueryVo
     */
    SingleQueryVo updateCoupon(Coupon coupon);

    /**
     * 删除优惠券
     * @param coupon
     * @return SingleQueryVo
     */
    SingleQueryVo deleteCoupon(Coupon coupon);

    /**
     * 增加优惠券
     * @param coupon
     * @return SingleQueryVo
     */
    SingleQueryVo create(Coupon coupon);

    /**
     * 获取单个优惠券信息
     * @param id
     * @return SingleQueryVo
     */
    SingleQueryVo read(int id);

    /**
     * 分页查询优惠券用户信息
     * @param pu
     * @param couponUser
     * @return BaseQueryVo
     */
    BaseQueryVo queryCouponUser(PageUtil pu, CouponUser couponUser);
}
