package com.cskaoyan.mall_springboot.bean.mallmg;

import org.springframework.stereotype.Component;

@Component
public class TopCategory {
private String label;
private String value;

    public TopCategory() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TopCategory{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
