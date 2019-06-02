package com.cskaoyan.mall_springboot.bean.resultvo;

import com.cskaoyan.mall_springboot.bean.goods.Goods;
import com.cskaoyan.mall_springboot.bean.mallmg.Category;

import java.util.Arrays;

/**
 * @author CZY-Y7000P
 */
public class WxGoodsQueryVo {
    private int count;
    private Category[] filterCategoryList;
    private Goods[] goodsList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Category[] getFilterCategoryList() {
        return filterCategoryList;
    }

    public void setFilterCategoryList(Category[] filterCategoryList) {
        this.filterCategoryList = filterCategoryList;
    }

    public Goods[] getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(Goods[] goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "WxGoodsQueryVo{" +
                "count=" + count +
                ", filterCategoryList=" + Arrays.toString(filterCategoryList) +
                ", goodsList=" + Arrays.toString(goodsList) +
                '}';
    }
}
