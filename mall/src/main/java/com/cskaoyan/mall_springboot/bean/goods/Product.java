package com.cskaoyan.mall_springboot.bean.goods;

import java.util.Arrays;

/**
 * @Author: zero
 * @Date: 2019/5/23 16:48
 * @Version 1.0
 */
public class Product {
    int id;
    int goodsId;
    String[] specifications;
    String price;
    String number;
    String url;
    String addTime;
    String updateTime;
    Boolean deleted;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", specifications=" + Arrays.toString(specifications) +
                ", price='" + price + '\'' +
                ", number='" + number + '\'' +
                ", url='" + url + '\'' +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String[] specifications) {
        this.specifications = specifications;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
