package com.cskaoyan.mall_springboot.bean.mallmg;

import org.springframework.stereotype.Component;

@Component
public class MallPageHelper {
    private int page;
    private int limit;
    private String sort;
    private String order;
    private Integer id;
    private String name;

    //获取偏移量
    public int getOffset(){
        return ((page - 1) * limit);
    }

    public MallPageHelper() {
    }

    public MallPageHelper(int page, int limit, String sort, String order, Integer id, String name) {
        this.page = page;
        this.limit = limit;
        this.sort = sort;
        this.order = order;
        this.id = id;
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
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

    @Override
    public String toString() {
        return "MallPageHelper{" +
                "page=" + page +
                ", limit=" + limit +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
