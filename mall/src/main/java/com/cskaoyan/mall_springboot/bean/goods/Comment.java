package com.cskaoyan.mall_springboot.bean.goods;

import java.util.Arrays;

/**
 * @Author: zero
 * @Date: 2019/5/25 9:26
 * @Version 1.0
 */
public class Comment {
    int id;
    int valueId;
    Boolean type;
    String content;
    int userId;
    Boolean hasPicture;
    String[] picUrls;
    int star;
    String addTime;
    String updateTime;
    Boolean deleted;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", valueId=" + valueId +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", hasPicture=" + hasPicture +
                ", picUrls=" + Arrays.toString(picUrls) +
                ", star=" + star +
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

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Boolean getHasPicture() {
        return hasPicture;
    }

    public void setHasPicture(Boolean hasPicture) {
        this.hasPicture = hasPicture;
    }

    public String[] getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String[] picUrls) {
        this.picUrls = picUrls;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
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
