package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.mallmg.Category;
import com.cskaoyan.mall_springboot.bean.mallmg.TopCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface CategoryMapper {
    ArrayList<Category> SelectAllCategory();

    ArrayList<TopCategory> SelectAllTopCategory();

    int InsertCategory(@Param("category") Category category);

    Category SelectOneCategoryByIconUrl(@Param("iconUrl") String iconUrl);

    int UpdateCategory(@Param("category") Category category);

    int DeleteCategoryById(@Param("id") Integer id);

    int DeleteCategoryByPid(@Param("pid") Integer pid);
}
