package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.mallmg.Category;
import com.cskaoyan.mall_springboot.bean.mallmg.TopCategory;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.mapper.CategoryMapper;
import com.cskaoyan.mall_springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    SingleQueryVo<ArrayList<Category>> categorySingleQueryVo = new SingleQueryVo<>();


    //封装分类
    @Override
    public SingleQueryVo<ArrayList<Category>> SelectAllCategory() {
        ArrayList<Category> categories = categoryMapper.SelectAllCategory();
        categorySingleQueryVo.setData(new ArrayList<Category>());
        if (categories.size() > 0) {
            categorySingleQueryVo.setErrno(0);
            categorySingleQueryVo.setErrmsg("成功");
        }
        for (Category category : categories) {
            if (category.getPid() != null && category.getPid() == 0) {
                category.setPid(null);
                categorySingleQueryVo.getData().add(category);
                for (Category category1 : categories) {
                    if (category1.getPid() != null && category1.getPid().equals(category.getId())) {
                        ArrayList<Category> children = category.getChildren();
                        if (children == null) {
                            category.setChildren(new ArrayList<Category>());
                            children = category.getChildren();
                        }
                        category1.setPid(null);
                        children.add(category1);
                    }
                }
            }
        }
        return categorySingleQueryVo;
    }
     //封装父分类
    @Override
    public SingleQueryVo<ArrayList<TopCategory>> SelectAllTopCategory() {
        ArrayList<TopCategory> topCategories = categoryMapper.SelectAllTopCategory();
        SingleQueryVo<ArrayList<TopCategory>> arrayListSingleQueryVo = new SingleQueryVo<>();
        if (topCategories.size() > 0) {
            arrayListSingleQueryVo.setErrmsg("成功");
            arrayListSingleQueryVo.setErrno(0);
            arrayListSingleQueryVo.setData(topCategories);
        }
        return arrayListSingleQueryVo;
    }
    //封装单个分类
    @Override
    public SingleQueryVo<Category> InsertCategory(Category category) {
        int i = categoryMapper.InsertCategory(category);
        SingleQueryVo<Category> categoryServiceSingleQueryVo = new SingleQueryVo<>();
        if (i>0) {
            Category category1 = categoryMapper.SelectOneCategoryByIconUrl(category.getIconUrl());
            if (category1 != null) {
                categoryServiceSingleQueryVo.setData(category1);
                categoryServiceSingleQueryVo.setErrno(0);
                categoryServiceSingleQueryVo.setErrmsg("成功");
            }
        }
        return categoryServiceSingleQueryVo;
    }

    @Override
    public SingleQueryVo UpdateCategory(Category category) {
        int i = categoryMapper.UpdateCategory(category);
        SingleQueryVo<Object> objectSingleQueryVo = new SingleQueryVo<>();
        if (i>0){
            objectSingleQueryVo.setErrmsg("成功");
            objectSingleQueryVo.setErrno(0);
        }
        return objectSingleQueryVo;
    }

    @Override
    public SingleQueryVo DeleteCategory(Category category) {
        SingleQueryVo<Object> objectSingleQueryVo = new SingleQueryVo<>();
        Category category1 = categoryMapper.SelectOneCategoryByIconUrl(category.getIconUrl());
        if (category1!=null) {
            int i = categoryMapper.DeleteCategoryById(category1.getId());
            int i1 = 1;
            if (category1.getPid() == 0) {
                i1 = categoryMapper.DeleteCategoryByPid(category1.getId());
            }
            if (i > 0 && i1 > 0) {
                objectSingleQueryVo.setErrno(0);
                objectSingleQueryVo.setErrmsg("成功");
            }
        }
        return objectSingleQueryVo;
    }
}
