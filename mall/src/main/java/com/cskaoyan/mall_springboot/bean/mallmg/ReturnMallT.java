package com.cskaoyan.mall_springboot.bean.managementmall;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReturnMallT<T>{
    Integer errno;
    List<T> data;
    String errmsg;

    public ReturnMallT() {
    }

    public ReturnMallT(Integer errno, List<T> data, String errmsg) {
        this.errno = errno;
        this.data = data;
        this.errmsg = errmsg;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    @Override
    public String toString() {
        return "ReturnMallT{" +
                "errno=" + errno +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }
}
