package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/23 0023 下午 3:19
 */
public interface AdminService {
    BaseQueryVo queryAdminList(PageHelper pageHelper, String name);
}
