package com.cskaoyan.mall_springboot.mapper;


import com.cskaoyan.mall_springboot.bean.coupon.Coupon;
import com.cskaoyan.mall_springboot.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
public interface CouponMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    Coupon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);

    /**
     * 查询优惠券总数
     * @param coupon
     * @return 总数
     */
    int selectCountCoupon(@Param("coupon") Coupon coupon);

    /**
     * 分页查询优惠券
     * @param pu
     * @param coupon
     * @return List<Coupon>
     */
    List<Coupon> queryAllCouponByPage(@Param("pu") PageUtil pu, @Param("coupon") Coupon coupon);
}