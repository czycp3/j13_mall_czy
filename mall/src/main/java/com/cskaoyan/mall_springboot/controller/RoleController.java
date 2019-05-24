package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.system.Role;
import com.cskaoyan.mall_springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/role/options")
    @ResponseBody
    public SingleQueryVo roleOpt(){

        return service.roleOpt();



//        SingleQueryVo singleQueryVo = new SingleQueryVo();
//        List list = new ArrayList();
//        Map<String,Object> map1 = new HashMap<>();
//        Map<String,Object> map2 = new HashMap<>();
//        Map<String,Object> map3 = new HashMap<>();
//        map1.put("label", "超级管理员");
//        map1.put("value", 1);
//        map2.put("label", "商场管理员");
//        map2.put("value", 2);
//        map3.put("label", "推广管理员");
//        map3.put("value", 3);
//        list.add(map1);
//        list.add(map2);
//        list.add(map3);
//        singleQueryVo.setErrno(0);
//        singleQueryVo.setErrmsg("成功");
//        singleQueryVo.setData(list);
//        return singleQueryVo;
    }
}
