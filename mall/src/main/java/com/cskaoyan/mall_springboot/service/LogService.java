package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/24 0024 上午 9:18
 */
public interface LogService {

    BaseQueryVo queryLogList(PageHelper pageHelper, String string);
}
