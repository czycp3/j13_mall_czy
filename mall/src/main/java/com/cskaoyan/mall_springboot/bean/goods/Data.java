package com.cskaoyan.mall_springboot.bean.goods;

import com.cskaoyan.mall_springboot.bean.mallmg.Category;
import com.fasterxml.jackson.annotation.JsonInclude;


import java.util.Arrays;
import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/22 22:30
 * @Version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Data<T> {
    List<T> items;
    Goods goods;
    List<Attribute> attributes;
    List<Specification> specifications;
    List<Product> products;

    List<Brand> brandList;
    List<Category> categoryList;
    int[] categoryIds;
    int total;


    @Override
    public String toString() {
        return "Data{" +
                "items=" + items +
                ", goods=" + goods +
                ", attributes=" + attributes +
                ", specifications=" + specifications +
                ", products=" + products +
                ", brandList=" + brandList +
                ", categoryList=" + categoryList +
                ", categoryIds=" + Arrays.toString(categoryIds) +
                ", total=" + total +
                '}';
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }


    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Specification> getSpecifications() {
        return specifications;
    }

    public void setSpecifications(List<Specification> specifications) {
        this.specifications = specifications;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int[] getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(int[] categoryIds) {
        this.categoryIds = categoryIds;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}

