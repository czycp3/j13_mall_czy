package com.cskaoyan.mall_springboot.bean.mallmg;


import org.springframework.stereotype.Component;


@Component
public class Brand {
    private Integer id;
    private String name;
    private String desc;
    private String picUrl;
    private Byte sortOrder;
    private String floorPrice;
    private String addTime;
    private String updateTime;
    private Boolean deleted;

    public Brand() {
    }

    public Brand(Integer id, String name, String desc, String picUrl, Byte sortOrder, String floorPrice, String addTime, String updateTime, Boolean deleted) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.picUrl = picUrl;
        this.sortOrder = sortOrder;
        this.floorPrice = floorPrice;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(String floorPrice) {
        this.floorPrice = floorPrice;
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

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", picUrl='" + picUrl + '\'' +
                ", sortOrder=" + sortOrder +
                ", floorPrice='" + floorPrice + '\'' +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
