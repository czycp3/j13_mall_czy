package com.cskaoyan.mall_springboot.bean.storage;

/**
 * @author CZY-Y7000P
 */
public class Storage {
    private int id;
    private String name;
    private String addTime;
    private String key;
    private long size;
    private String type;
    private String updateTime;
    private String url;
    private Boolean deleted;

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddTime() {
        return addTime;
    }

    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addTime='" + addTime + '\'' +
                ", key='" + key + '\'' +
                ", size=" + size +
                ", type='" + type + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", url='" + url + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
