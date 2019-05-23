package com.cskaoyan.mall_springboot.bean.goods;

import org.springframework.stereotype.Component;

/**
 * @Author: zero
 * @Date: 2019/5/22 22:12
 * @Version 1.0
 */
@Component
public class BaseResultVo {
    int errno;
    Data data;
    String errmsg;

    @Override
    public String toString() {
        return "BaseResultVo{" +
                "errno=" + errno +
                ", data=" + data +
                ", errmsg='" + errmsg + '\'' +
                '}';
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
