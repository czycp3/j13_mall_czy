package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.WxQueryVo;


/**
 * @author CZY-Y7000P
 */
public interface MainService {
    /**
     * 查询主业统计信息
     * @return BaseQueryVo
     */
    BaseQueryVo queryStatics();

    /**
     * 查询index页面所有信息
     * @return WxQueryVo
     */
    WxQueryVo queryMainInfo();

}
