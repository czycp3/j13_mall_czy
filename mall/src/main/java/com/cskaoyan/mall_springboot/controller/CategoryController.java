package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.mallmg.Category;
import com.cskaoyan.mall_springboot.bean.mallmg.TopCategory;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @RequestMapping("/list")
    public SingleQueryVo<ArrayList<Category>> SelectAllCategory(){
        SingleQueryVo<ArrayList<Category>> categorySingleQueryVo = categoryService.SelectAllCategory();
       return categorySingleQueryVo;
    }
    @RequestMapping("/l1")
    public SingleQueryVo<ArrayList<TopCategory>> SelectAllTopCategory(){
        SingleQueryVo<ArrayList<TopCategory>> singleQueryVo =categoryService.SelectAllTopCategory();
        return singleQueryVo;
    }
    @RequestMapping("/create")
    public SingleQueryVo<Category> InsertCategory(@RequestBody Category category){
        SingleQueryVo<Category> singleQueryVo=categoryService.InsertCategory(category);
        return singleQueryVo;
    }
    @RequestMapping("/update")
    public SingleQueryVo UpdateCategory(@RequestBody Category category){
        SingleQueryVo singleQueryVo =categoryService.UpdateCategory(category);
        return singleQueryVo;
    }
    @RequestMapping("/delete")
    public SingleQueryVo DeleteCategory(@RequestBody Category category){
        SingleQueryVo singleQueryVo=categoryService.DeleteCategory(category);
        return singleQueryVo;
    }
}
