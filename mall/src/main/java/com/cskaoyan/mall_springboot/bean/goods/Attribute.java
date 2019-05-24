package com.cskaoyan.mall_springboot.bean.goods;

/**
 * @Author: zero
 * @Date: 2019/5/23 16:43
 * @Version 1.0
 */
public class Attribute {
    int id;
    int goodsId;
    String attribute;
    String value;
    String addTime;
    String updateTime;
    Boolean deleted;

    @Override
    public String toString() {
        return "Attribute{" +
                "id=" + id +
                ", goodsId=" + goodsId +
                ", attribute='" + attribute + '\'' +
                ", value='" + value + '\'' +
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

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
