package com.cskaoyan.mall_springboot.bean;

/**
 * @auther 芮狼Dan
 * @date 2019-05-22 23:33
 */
public class System {

    private Integer id;
    private String keyName;
    private String keyValue;
    private String  addTime;
    private String updateTime;
    private Boolean deleted;

    public System() {
    }

    public System(Integer id, String keyName, String keyValue, String addTime, String updateTime, Boolean deleted) {
        this.id = id;
        this.keyName = keyName;
        this.keyValue = keyValue;
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

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
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
        return "System{" +
                "id=" + id +
                ", keyName='" + keyName + '\'' +
                ", keyValue='" + keyValue + '\'' +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
