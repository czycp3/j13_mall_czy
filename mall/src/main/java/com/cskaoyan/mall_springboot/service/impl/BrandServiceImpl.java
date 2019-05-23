package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.mallmg.Brand;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.mapper.BrandMapper;
import com.cskaoyan.mall_springboot.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;
    BaseQueryVo<Brand> brandBaseQueryVo = new BaseQueryVo<>();
    ResultVo<Brand> brandResultVo = new ResultVo<>();
    SingleQueryVo<Brand> brandSingleQueryVo = new SingleQueryVo<>();

    @Override
    public BaseQueryVo<Brand> SelectBrandByPageIdName(MallPageHelper mallPageHelper) {
        //查询Brand
        Integer integer = brandMapper.SelectBrandCount(mallPageHelper);
        int offset = mallPageHelper.getOffset();
        ArrayList<Brand> brands = brandMapper.SelectBrandByPageIdName(mallPageHelper, offset);
        brandResultVo.setItems(brands);
        brandResultVo.setTotal(integer);
        if (brands.size() > 0) {
            brandBaseQueryVo.setErrmsg("成功");
            brandBaseQueryVo.setErrno(0);
            brandBaseQueryVo.setData(brandResultVo);
        }
        return brandBaseQueryVo;
    }

    @Override
    public SingleQueryVo<Brand> InsertBrand(Brand brand) {
        //新增Brand
        brandSingleQueryVo = BrandMatch(brand);
        if (brandSingleQueryVo.getErrno() == 401) {
            return brandSingleQueryVo;
        }
        Byte sortOrder = brandMapper.SelectMaxSortOrder();
        brand.setSortOrder(sortOrder);
        int i = brandMapper.InsertBrand(brand);
        Brand brand1 = brandMapper.SelectBrandByPicUrl(brand.getPicUrl());
        if (i > 0) {
            brandSingleQueryVo.setData(brand1);
            brandSingleQueryVo.setErrno(0);
            brandSingleQueryVo.setErrmsg("成功");
        }
        return brandSingleQueryVo;
    }

    @Override
    public SingleQueryVo<Brand> UpdateBrand(Brand brand) {
        brandSingleQueryVo = BrandMatch(brand);
        if (brandSingleQueryVo.getErrno() == 401){
            return brandSingleQueryVo;
        }
        int i = brandMapper.UpdateBrand(brand);
        if (i>0){
            brandSingleQueryVo.setErrmsg("成功");
            brandSingleQueryVo.setData(brand);
            brandSingleQueryVo.setErrno(0);
        }
        return brandSingleQueryVo;
    }

    @Override
    public SingleQueryVo DeleteBrandById(Integer id) {
        int i = brandMapper.DeleteBrandById(id);
        if (i>0){
            brandSingleQueryVo.setErrno(0);
            brandSingleQueryVo.setErrmsg("成功");
        }
        return brandSingleQueryVo;
    }

    public SingleQueryVo<Brand> BrandMatch(Brand brand) {
        String desc = brand.getDesc();
        String floorPrice = brand.getFloorPrice();
        String name = brand.getName();
        String picUrl = brand.getPicUrl();
        if (desc == null || desc.equals("") || floorPrice == null || !(floorPrice.matches("^[0-9]+(.[0-9]{1,2})?$")) || name == null || name.equals("") || picUrl == null || picUrl.equals("")) {
            brandSingleQueryVo.setErrmsg("参数不对");
            brandSingleQueryVo.setErrno(401);
            brandSingleQueryVo.setData(brand);
            return brandSingleQueryVo;
        }else{
            brandSingleQueryVo.setErrno(1);
        }
        return brandSingleQueryVo;
    }
}
