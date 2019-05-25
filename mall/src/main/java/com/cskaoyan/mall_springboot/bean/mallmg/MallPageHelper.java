package com.cskaoyan.mall_springboot.bean.mallmg;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MallPageHelper {
    private int page;
    private int limit;
    private String sort;
    private String order;
    private Integer id;
    private String name;
    private Integer userId;
    private String orderSn;
    private int[] orderStatusArray;
    private String question;
    private String keyword;
    private String url;

    //获取偏移量
    public int getOffset(){
        return ((page - 1) * limit);
    }

    public MallPageHelper() {
    }

    public MallPageHelper(int page, int limit, String sort, String order, Integer id, String name, Integer userId, String orderSn, int[] orderStatusArray, String question, String keyword, String url) {
        this.page = page;
        this.limit = limit;
        this.sort = sort;
        this.order = order;
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.orderSn = orderSn;
        this.orderStatusArray = orderStatusArray;
        this.question = question;
        this.keyword = keyword;
        this.url = url;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public int[] getOrderStatusArray() {
        return orderStatusArray;
    }

    public void setOrderStatusArray(int[] orderStatusArray) {
        this.orderStatusArray = orderStatusArray;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
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

    @Override
    public String toString() {
        return "MallPageHelper{" +
                "page=" + page +
                ", limit=" + limit +
                ", sort='" + sort + '\'' +
                ", order='" + order + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", orderSn='" + orderSn + '\'' +
                ", orderStatusArray=" + Arrays.toString(orderStatusArray) +
                ", question='" + question + '\'' +
                ", keyword='" + keyword + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
