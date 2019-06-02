package com.cskaoyan.mall_springboot.bean.resultvo;

import com.cskaoyan.mall_springboot.bean.ad.Ad;
import com.cskaoyan.mall_springboot.bean.coupon.Coupon;
import com.cskaoyan.mall_springboot.bean.goods.Goods;
import com.cskaoyan.mall_springboot.bean.mallmg.Brand;
import com.cskaoyan.mall_springboot.bean.topic.Topic;
import com.cskaoyan.mall_springboot.bean.wx.FloorGoodsList;
import com.cskaoyan.mall_springboot.bean.mallmg.Category;
import com.cskaoyan.mall_springboot.bean.wx.GrouponList;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
public class WxResultVo {
    private List<Ad> banner;
    private List<Brand> brandList;
    private List<Category> channel;
    private List<Coupon> couponList;
    private List<FloorGoodsList> floorGoodsList;
    private List<GrouponList> grouponList;
    private List<Goods> hotGoodsList;
    private List<Goods> newGoodsList;
    private List<Topic> topicList;
    private Brand brand;

    @Override
    public String toString() {
        return "WxResultVo{" +
                "banner=" + banner +
                ", brandList=" + brandList +
                ", channel=" + channel +
                ", couponList=" + couponList +
                ", floorGoodsList=" + floorGoodsList +
                ", grouponList=" + grouponList +
                ", hotGoodsList=" + hotGoodsList +
                ", newGoodsList=" + newGoodsList +
                ", topicList=" + topicList +
                ", brand=" + brand +
                '}';
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<Ad> getBanner() {
        return banner;
    }

    public void setBanner(List<Ad> banner) {
        this.banner = banner;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public List<Category> getChannel() {
        return channel;
    }

    public void setChannel(List<Category> channel) {
        this.channel = channel;
    }

    public List<Coupon> getCouponList() {
        return couponList;
    }

    public void setCouponList(List<Coupon> couponList) {
        this.couponList = couponList;
    }

    public List<FloorGoodsList> getFloorGoodsList() {
        return floorGoodsList;
    }

    public void setFloorGoodsList(List<FloorGoodsList> floorGoodsList) {
        this.floorGoodsList = floorGoodsList;
    }

    public List<GrouponList> getGrouponList() {
        return grouponList;
    }

    public void setGrouponList(List<GrouponList> grouponList) {
        this.grouponList = grouponList;
    }

    public List<Goods> getHotGoodsList() {
        return hotGoodsList;
    }

    public void setHotGoodsList(List<Goods> hotGoodsList) {
        this.hotGoodsList = hotGoodsList;
    }

    public List<Goods> getNewGoodsList() {
        return newGoodsList;
    }

    public void setNewGoodsList(List<Goods> newGoodsList) {
        this.newGoodsList = newGoodsList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

}
