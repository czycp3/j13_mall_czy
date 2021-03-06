package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.coupon.Coupon;
import com.cskaoyan.mall_springboot.bean.coupon.CouponUser;
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
                singleQueryVo.setErrmsg("成功");
                singleQueryVo.setErrno(0);
                singleQueryVo.setData(coupon);
            }
        }catch (Exception e){
            singleQueryVo.setErrmsg("增加失败");
            throw new RuntimeException(e);
        }
        return singleQueryVo;
    }

    /**
     * 查询单个优惠券的信息
     * @param id
     * @return SingleQueryVo
     */
    @Override
    public SingleQueryVo read(int id) {
        SingleQueryVo<Coupon> singleQueryVo = new SingleQueryVo<>();
        Coupon coupon = couponMapper.selectByPrimaryKey(id);
        singleQueryVo.setErrmsg("成功");
        singleQueryVo.setErrno(0);
        singleQueryVo.setData(coupon);
        return singleQueryVo;
    }

    /**
     * 分页查询优惠券用户信息
     * @param pu
     * @param couponUser
     * @return BaseQueryVo
     */
    @Override
    public BaseQueryVo queryCouponUser(PageUtil pu, CouponUser couponUser) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<CouponUser> resultVo = new ResultVo<>();

        int total = couponMapper.selectCountCouponUser(couponUser);
        pu.setOffset();

        List<CouponUser> cpuList = couponMapper.queryAllCouponUserByPage(pu,couponUser);

        resultVo.setItems(cpuList);
        resultVo.setTotal(total);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");

        baseQueryVo.setData(resultVo);
        return baseQueryVo;
    }


}
