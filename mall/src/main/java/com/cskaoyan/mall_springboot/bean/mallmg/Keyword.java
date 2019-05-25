package com.cskaoyan.mall_springboot.bean.mallmg;

public class Keyword {
    private Integer id;
    private String keyword;
    private String url;
    private Boolean isHot;
    private Boolean isDefault;
    private Integer sortOrder;
    private String addTime;
    private String updateTime;
    private Boolean deleted;

    public Keyword() {
    }

    public Keyword(Integer id, String keyword, String url, Boolean isHot, Boolean isDefault, Integer sortOrder, String addTime, String updateTime, Boolean deleted) {
        this.id = id;
        this.keyword = keyword;
        this.url = url;
        this.isHot = isHot;
        this.isDefault = isDefault;
        this.sortOrder = sortOrder;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getHot() {
        return isHot;
    }

    public void setHot(Boolean hot) {
        isHot = hot;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
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
        return "Keyword{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", url='" + url + '\'' +
                ", isHot=" + isHot +
                ", isDefault=" + isDefault +
                ", sortOrder=" + sortOrder +
                ", addTime='" + addTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
