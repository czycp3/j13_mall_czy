package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.mallmg.Category;
import com.cskaoyan.mall_springboot.bean.mallmg.TopCategory;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;

import java.util.ArrayList;

public interface CategoryService {
    SingleQueryVo<ArrayList<Category>> SelectAllCategory();

    SingleQueryVo<ArrayList<TopCategory>> SelectAllTopCategory();

    SingleQueryVo<Category> InsertCategory(Category category);

    SingleQueryVo UpdateCategory(Category category);

    SingleQueryVo DeleteCategory(Category category);
}
