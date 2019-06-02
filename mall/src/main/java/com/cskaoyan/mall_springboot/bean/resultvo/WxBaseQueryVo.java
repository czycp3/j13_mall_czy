package com.cskaoyan.mall_springboot.bean.resultvo;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
public class WxBaseQueryVo<T> {
    private int errno;
    private String errmsg;
    private List<T> data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WxBaseQueryVo{" +
                "errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }
}
