package com.cskaoyan.mall_springboot.bean.goods;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/22 22:30
 * @Version 1.0
 */
@Component
public class Data<T> {
    List<T> items;
    int total;

    @Override
    public String toString() {
        return "Data{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
