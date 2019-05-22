package com.cskaoyan.mall_springboot.bean;


/**
 * @author CZY-Y7000P
 */
public class BaseQueryVo<T> {
    private int errno;
    private String errmsg;
    private ResultVo<T> data;

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

    public ResultVo<T> getData() {
        return data;
    }

    public void setData(ResultVo<T> data) {
        this.data = data;
    }
}
