package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.mallmg.Brand;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.WxQueryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface BrandMapper {
    Integer SelectBrandCount (@Param("mallPageHelper") MallPageHelper mallPageHelper);

    ArrayList<Brand> SelectBrandByPageIdName(@Param("mallPageHelper") MallPageHelper mallPageHelper, @Param("offset") Integer offset);

    Byte SelectMaxSortOrder();

    int InsertBrand(@Param("brand") Brand brand);

    Brand SelectBrandByPicUrl(@Param("picUrl") String picUrl);

    int UpdateBrand(@Param("brand") Brand brand);

    int DeleteBrandById(@Param("id") Integer id);

    /**
     * 查询品牌列表
     * @author CZY
     * @return List<Brand>
     */
    List<Brand> queryBrandList();

    /**
     * 按ID查询品牌详情
     * @param id
     * @return Brand
     */
    Brand queryBrandDetailById(int id);
}
