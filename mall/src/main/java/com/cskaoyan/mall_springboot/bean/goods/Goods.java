package com.cskaoyan.mall_springboot.bean.goods;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Author: zero
 * @Date: 2019/5/22 22:18
 * @Version 1.0
 */
@Component
public class Goods {
    //创建时间
    String addTime;
    int brandId;
    //商品简介
    String brief;
    //商品所属类目ID
    int categoryId;
    //专柜价格
    BigDecimal counterPrice;
    //逻辑删除
    Boolean deleted;
    //商品宣传图片列表
    String[] gallery;
    //商品编号
    String goodsSn;
    //
    int id;
    //是否人气推荐，如果设置则可以在人气推荐页面展示
    Boolean isHot;
    //是否新品首发，如果设置则可以在新品首发页面展示
    Boolean isNew;
    //是否上架
    Boolean isOnSale;
    //商品关键字，中间采用逗号隔开了
    String keywords;
    //商品名称
    String name;
    //商品页面商品图片
    String picUrl;
    //零售价格
    int retailPrice;
    //商品分享朋友圈价格
    String shareUrl;
    //
    String sortOrder;
    //商品单位
    String unit;
    //更新时间
    String updateTime;
    //商品详细介绍
    String detail;

    @Override
    public String toString() {
        return "Goods{" +
                "addTime='" + addTime + '\'' +
                ", brandId=" + brandId +
                ", brief='" + brief + '\'' +
                ", categoryId=" + categoryId +
                ", counterPrice=" + counterPrice +
                ", deleted=" + deleted +
                ", gallery=" + Arrays.toString(gallery) +
                ", goodsSn='" + goodsSn + '\'' +
                ", id=" + id +
                ", isHot=" + isHot +
                ", isNew=" + isNew +
                ", isOnSale=" + isOnSale +
                ", keywords='" + keywords + '\'' +
                ", name='" + name + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", retailPrice=" + retailPrice +
                ", shareUrl='" + shareUrl + '\'' +
                ", sortOrder='" + sortOrder + '\'' +
                ", unit='" + unit + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public String[] getGallery() {
        return gallery;
    }

    public void setGallery(String[] gallery) {
        this.gallery = gallery;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getCounterPrice() {
        return counterPrice;
    }

    public void setCounterPrice(BigDecimal counterPrice) {
        this.counterPrice = counterPrice;
    }



    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean isdeleted) {
        this.deleted = deleted;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean ishot) {
        isHot = ishot;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsOnSale() {
        return isOnSale;
    }

    public void setIsOnSale(Boolean isonSale) {
        isOnSale = isonSale;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(int retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
