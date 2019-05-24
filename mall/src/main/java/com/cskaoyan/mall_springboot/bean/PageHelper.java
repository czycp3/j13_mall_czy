package com.cskaoyan.mall_springboot.bean;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/22 0022 下午 9:59
 */
public class PageHelper {
    private int page;
    private int limit;
    private String sort;
    private String order;
    private int offset;

    public void setOffset() {
        this.offset = ((page - 1) * limit);
    }

    //获取偏移量
    public int getOffset(){
        return ((page - 1) * limit);
    }

    @Override
    public String toString() {
        return "PageHelper{" +
                "page=" + page +
                ", limit=" + limit +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                '}';
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
