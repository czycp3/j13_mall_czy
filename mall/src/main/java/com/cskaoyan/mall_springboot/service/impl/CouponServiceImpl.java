package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.coupon.Coupon;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.mapper.CouponMapper;
import com.cskaoyan.mall_springboot.service.CouponService;
import com.cskaoyan.mall_springboot.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Service
public class CouponServiceImpl implements CouponService {

    private CouponMapper couponMapper;

    @Autowired
    public CouponServiceImpl(CouponMapper couponMapper) {
        this.couponMapper = couponMapper;
    }

    /**
     * 分页查询优惠券
     * @param pu
     * @param coupon
     * @return BaseQueryVo
     */
    @Override
    public BaseQueryVo queryAllCouponByPage(PageUtil pu, Coupon coupon) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<Coupon> resultVo = new ResultVo<>();
        String name = coupon.getName();
        if (name != null) {
            name = "%" + name + "%";
            coupon.setName(name);
        }

        int total = couponMapper.selectCountCoupon(coupon);
        pu.setOffset();

        List<Coupon> cpList = couponMapper.queryAllCouponByPage(pu,coupon);

        resultVo.setItems(cpList);
        resultVo.setTotal(total);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");

        baseQueryVo.setData(resultVo);
        return baseQueryVo;
    }

    /**
     * 更新优惠券
     * @param coupon
     * @return SingleQueryVo
     */
    @Override
    public SingleQueryVo updateCoupon(Coupon coupon) {
        SingleQueryVo<Coupon> singleQueryVo = new SingleQueryVo<>();
        try {
            int ret =  couponMapper.updateByPrimaryKeySelective(coupon);
            if(ret != 0){
                Coupon coupon1 = couponMapper.selectByPrimaryKey(coupon.getId());
                singleQueryVo.setData(coupon1);
                singleQueryVo.setErrmsg("成功");
                singleQueryVo.setErrno(0);
            }
        }catch (Exception e){
            singleQueryVo.setErrmsg("更新失败");
            throw new RuntimeException(e);
        }
        return singleQueryVo;
    }

    /**
     * 删除优惠券
     * @param coupon
     * @return SingleQueryVo
     */
    @Override
    public SingleQueryVo deleteCoupon(Coupon coupon) {
        SingleQueryVo<Coupon> singleQueryVo = new SingleQueryVo<>();

        try {
            coupon.setDeleted(1);
            int ret = couponMapper.updateByPrimaryKeySelective(coupon);
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

    /**
     * 增加优惠券
     * @param coupon
     * @return SingleQueryVo
     */
    @Override
    public SingleQueryVo create(Coupon coupon) {
        SingleQueryVo<Coupon> singleQueryVo = new SingleQueryVo<>();
        try {
            int ret = couponMapper.insertSelective(coupon);
            if(ret == 1) {
                Coupon coupon1 = couponMapper.selectByPrimaryKey(coupon.getId());
                singleQueryVo.setErrmsg("成功");
                singleQueryVo.setErrno(0);
                singleQueryVo.setData(coupon1);
            }
        }catch (Exception e){
            singleQueryVo.setErrmsg("增加失败");
            throw new RuntimeException(e);
        }
        return singleQueryVo;
    }


}
