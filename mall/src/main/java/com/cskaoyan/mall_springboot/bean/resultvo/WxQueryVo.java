package com.cskaoyan.mall_springboot.bean.resultvo;

/**
 * @author CZY-Y7000P
 */
public class WxQueryVo {
    private int errno;
    private String errmsg;
    private WxResultVo data;

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

    public WxResultVo getData() {
        return data;
    }

    public void setData(WxResultVo data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WxQueryVo{" +
                "errno=" + errno +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }
}
