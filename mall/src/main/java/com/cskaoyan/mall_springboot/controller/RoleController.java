package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.system.Role;
import com.cskaoyan.mall_springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/22 0022 下午 9:58
 */
@Controller
public class RoleController {
    @Autowired
    RoleService service;

    @RequestMapping("/role/list")
    @ResponseBody
    public BaseQueryVo queryRoleList(PageHelper pageHelper,String name){
        return service.queryRoleList(pageHelper,name);
    }

    @RequestMapping("/role/update")
    @ResponseBody
    public BaseQueryVo roleUpdate(@RequestBody Role role){
        return service.roleUpdate(role);
    }

    @RequestMapping("/role/delete")
    @ResponseBody
    public BaseQueryVo roleDelete(@RequestBody Role role){
        return service.roleDelete(role);
    }

    @RequestMapping("/role/create")
    @ResponseBody
    public SingleQueryVo roleInsert(@RequestBody Role role){
        return service.roleInsert(role);
    }
}
