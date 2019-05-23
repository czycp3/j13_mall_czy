package com.cskaoyan.mall_springboot.util;

/**
 * @author CZY-Y7000P
 */
public class PageUtil<T> {
    private  int page;
    private  int limit;
    private String sort;
    private String order;
    private  int offset;
    private T requestBean;

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

    public int getOffset() {
        return offset;
    }

    public void setOffset() {
        this.offset = (this.page - 1) * this.limit;
    }

    public T getRequestBean() {
        return requestBean;
    }

    public void setRequestBean(T requestBean) {
        this.requestBean = requestBean;
    }
}
