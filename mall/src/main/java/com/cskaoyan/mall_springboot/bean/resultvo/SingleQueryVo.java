package com.cskaoyan.mall_springboot.bean.resultvo;

/**
 * @author CZY-Y7000P
 */
public class SingleQueryVo<T> {
    private T data;
    private String errmsg;
    private int errno;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    @Override
    public String toString() {
        return "SingleQueryVo{" +
                "data=" + data +
                ", errmsg='" + errmsg + '\'' +
                ", errno=" + errno +
                '}';
    }
}
