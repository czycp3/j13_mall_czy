package com.cskaoyan.mall_springboot.bean.goods;

/**
 * @Author: zero
 * @Date: 2019/5/24 9:21
 * @Version 1.0
 */
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Component
public class Category {
    private String label;
    private Integer value;
    List<Category> children;

    public Category() {
    }

    @Override
    public String toString() {
        return "Category{" +
                "label='" + label + '\'' +
                ", value=" + value +
                ", children=" + children +
                '}';
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Category> getChildren() {
        return children;
    }

    public void setChildren(List<Category> children) {
        this.children = children;
    }
}
