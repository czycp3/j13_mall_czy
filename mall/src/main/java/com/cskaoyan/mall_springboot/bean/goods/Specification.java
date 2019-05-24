package com.cskaoyan.mall_springboot.bean.goods;

/**
 * @Author: zero
 * @Date: 2019/5/23 16:47
 * @Version 1.0
 */
public class Specification {
    int id;
    int goodsId;
    String specification;
    String value;
    String picUrl;
    String addTime;
    String updateTime;
    Boolean deleted;

    @Override
    public String toString() {
        return "Specification{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", specification='" + specification + '\'' +
                ", value='" + value + '\'' +
                ", picUrl='" + picUrl + '\'' +
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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
