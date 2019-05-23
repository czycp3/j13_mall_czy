package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.system.Role;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/22 0022 下午 10:02
 */
public interface RoleService {
    BaseQueryVo queryRoleList(PageHelper pageHelper,String name);

    BaseQueryVo roleUpdate(Role role);

    BaseQueryVo roleDelete(Role role);

    SingleQueryVo roleInsert(Role role);
}
