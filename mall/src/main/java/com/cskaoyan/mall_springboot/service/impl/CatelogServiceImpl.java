package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;
import com.cskaoyan.mall_springboot.bean.goods.Data;
import com.cskaoyan.mall_springboot.bean.mallmg.Category;
import com.cskaoyan.mall_springboot.mapper.CategoryMapper;
import com.cskaoyan.mall_springboot.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/27 15:49
 * @Version 1.0
 */
@Service
public class CatelogServiceImpl implements CatelogService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public BaseResultVo getCatalogIndex() {
        //获得一级分类信息
        int pid =0;
        List<Category> categoryList = categoryMapper.getCategoryListByPid(pid);
        //获得默认首页的居家分类信息
        int id = 1005000;
        Category currentCatagory = categoryMapper.selectCategoryById(id);
        //获得居家下的二级目录分类信息
        List<Category> currentSubCategory = categoryMapper.getCategoryListByPid(id);
        return packaging(categoryList,currentCatagory,currentSubCategory);
    }

    @Override
    public BaseResultVo getCurrentCatalogById(Object id) {
        Category currentCatagory= categoryMapper.selectCategoryById((int)id);
        List<Category> currentSubCategory = categoryMapper.getCategoryListByPid((int)id);
        return packaging(null,currentCatagory,currentSubCategory);
    }

    private BaseResultVo packaging(List categoryList,Category currentCatagory,List currentSubCategory){
        BaseResultVo baseResultVo = new BaseResultVo();
        Data<Object> data = new Data<>();
        if(categoryList!=null){
            data.setCategoryList(categoryList);
        }
        if(currentCatagory!=null){
            data.setCurrentCatagory(currentCatagory);
        }
        if(currentSubCategory!=null){
            data.setCurrentSubCategory(currentSubCategory);
        }
        baseResultVo.setData(data);
        baseResultVo.setErrno(0);
        baseResultVo.setErrmsg("成功");
        return baseResultVo;
    }
}
