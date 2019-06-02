package com.cskaoyan.mall_springboot.bean.wx;

import com.cskaoyan.mall_springboot.bean.goods.Goods;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
public class FloorGoodsList {
    private Integer id;
    private String name;
    private List<Goods> goodsList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "FloorGoodsList{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goodsList=" + goodsList +
                '}';
    }
}
