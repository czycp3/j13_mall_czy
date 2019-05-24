package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.mallmg.Brand;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandService brandService;
    @RequestMapping("/list")
    public BaseQueryVo<Brand> SelectBrandByPageIdName(MallPageHelper mallPageHelper){
        BaseQueryVo<Brand> brandByPage= brandService.SelectBrandByPageIdName(mallPageHelper);
        return brandByPage;
    }
    @RequestMapping("/create")
    public SingleQueryVo<Brand> InsertBrand(@RequestBody Brand brand){
        SingleQueryVo<Brand> brandSingleQueryVo = brandService.InsertBrand(brand);
        return brandSingleQueryVo;
    }
    @RequestMapping("/update")
    public SingleQueryVo<Brand> UpdateBrand(@RequestBody Brand brand){
        SingleQueryVo<Brand> brandSingleQueryVo =brandService.UpdateBrand(brand);
        return  brandSingleQueryVo;
    }
    @RequestMapping("/delete")
    public SingleQueryVo deleteBrandById(@RequestBody Brand brand){
      SingleQueryVo  singleQueryVo =  brandService.DeleteBrandById(brand.getId());
      return singleQueryVo;
    }
}
