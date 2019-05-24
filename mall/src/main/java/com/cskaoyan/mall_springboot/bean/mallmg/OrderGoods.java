package com.cskaoyan.mall_springboot.bean.mallmg;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.DecimalFormatSymbols;

@Component
public class OrderGoods {
    private Integer id;
    private Integer orderId;
    private Integer goodsId;
    private String goodsName;
    private String goodsSn;
    private Integer productId;
    private Integer number;
    private BigDecimal price;
    private String specifications;
    private String picUrl;
    private Integer comment;
    private String addTime;
    private String updateTime;
    private boolean deleted;

    public OrderGoods() {
    }

    public OrderGoods(Integer id, Integer orderId, Integer goodsId, String goodsName, String goodsSn, Integer productId, Integer number, BigDecimal price, String specifications, String picUrl, Integer comment, String addTime, String updateTime, boolean deleted) {
        this.id = id;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsSn = goodsSn;
        this.productId = productId;
        this.number = number;
        this.price = price;
        this.specifications = specifications;
        this.picUrl = picUrl;
        this.comment = comment;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getComment() {
        return comment;
    }

    public void setComment(Integer comment) {
        this.comment = comment;
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsSn='" + goodsSn + '\'' +
                ", productId=" + productId +
                ", number=" + number +
                ", price=" + price +
                ", specifications='" + specifications + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", comment=" + comment +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
