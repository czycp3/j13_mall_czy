package com.cskaoyan.mall_springboot.bean.mallmg;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.stereotype.Component;

import java.util.List;
@Component

public class Region {
    Integer id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    Integer pid;
    String name;
    Integer type;
    Integer code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<Region> children;

    public Region() {
    }

    public Region(Integer id, Integer pid, String name, Integer type, Integer code, List<Region> children) {
        this.id = id;
        this.pid = pid;
        this.name = name;
        this.type = type;
        this.code = code;
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Region> getChildren() {
        return children;
    }

    public void setChildren(List<Region> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", code=" + code +
                ", children=" + children +
                '}';
    }
}
