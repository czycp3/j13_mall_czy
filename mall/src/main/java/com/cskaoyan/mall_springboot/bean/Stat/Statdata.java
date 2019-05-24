package com.cskaoyan.mall_springboot.bean.Stat;

import java.util.List;
import java.util.Map;

/**
 * @Author: 頽小废
 * @Date: 2019/5/23 21:13
 * @Compony: http://www.tuixiaofei.com
 */
public class Statdata {
    private String[] columns;
    private List<Map> rows;

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public List<Map> getRows() {
        return rows;
    }

    public void setRows(List<Map> rows) {
        this.rows = rows;
    }
}
