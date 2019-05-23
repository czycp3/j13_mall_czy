package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.mallmg.Brand;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface BrandMapper {
    Integer SelectBrandCount ();

    ArrayList<Brand> SelectBrandByPageIdName(@Param("mallPageHelper") MallPageHelper mallPageHelper, @Param("offset") Integer offset);

    Byte SelectMaxSortOrder();

    int InsertBrand(@Param("brand") Brand brand);

    Brand SelectBrandByPicUrl(@Param("picUrl") String picUrl);

    int UpdateBrand(@Param("brand") Brand brand);

    int DeleteBrandById(@Param("id") Integer id);
}
