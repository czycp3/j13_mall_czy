package com.cskaoyan.mall_springboot.bean.goods;

/**
 * @Author: zero
 * @Date: 2019/5/23 17:15
 * @Version 1.0
 */

public class Brand {
    private Integer value;
    private String label;

    public Brand() {
    }

    @Override
    public String toString() {
        return "Brand{" +
                "value=" + value +
                ", label='" + label + '\'' +
                '}';
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
