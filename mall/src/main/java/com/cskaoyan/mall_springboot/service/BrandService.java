package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.mallmg.Brand;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;

public interface BrandService {
    BaseQueryVo<Brand> SelectBrandByPageIdName(MallPageHelper mallPageHelper);

    SingleQueryVo<Brand> InsertBrand(Brand brand);

    SingleQueryVo<Brand> UpdateBrand(Brand brand);

    SingleQueryVo DeleteBrandById(Integer id);
}
