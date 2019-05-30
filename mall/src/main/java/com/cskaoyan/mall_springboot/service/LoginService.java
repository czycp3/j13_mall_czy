package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.Admin;

import java.util.List;
import java.util.Set;

/**
 * @auther 芮狼Dan
 * @date 2019-05-23 22:43
 */
public interface LoginService {
    void upDateById(Admin admin);

    //根据用户名寻找admin
    List<Admin> findAdminByUsername(String username);

    //找rolesIds
    Set<String> quaryByIds(Integer[] roleIds);

    //找permissions
    Set<String> quaryByRoleIds(Integer[] roleIds);

}
