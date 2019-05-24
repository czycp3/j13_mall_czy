package com.cskaoyan.mall_springboot.bean.groupon;

import java.math.BigDecimal;

/**
 * @author CZY-Y7000P
 */
public class Groupon {
    private int id;
    private String goodsId;
    private String goodsName;
    private String picUrl;
    private BigDecimal discount;
    private int discountMember;
    private String addTime;
    private String updateTime;
    private String expireTime;
    private int deleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getDiscountMember() {
        return discountMember;
    }

    public void setDiscountMember(int discountMember) {
        this.discountMember = discountMember;
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

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Groupon{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", discount=" + discount +
                ", discountMember=" + discountMember +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", expireTime='" + expireTime + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
