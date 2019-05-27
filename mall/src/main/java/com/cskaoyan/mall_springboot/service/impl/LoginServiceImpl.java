package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.Admin;
import com.cskaoyan.mall_springboot.bean.system.Permission;
import com.cskaoyan.mall_springboot.bean.system.Role;
import com.cskaoyan.mall_springboot.mapper.login.LoginMapper;
import com.cskaoyan.mall_springboot.mapper.login.LoginPermissionMapper;
import com.cskaoyan.mall_springboot.mapper.login.LoginRolesMapper;
import com.cskaoyan.mall_springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @auther 芮狼Dan
 * @date 2019-05-23 22:43
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;
    @Autowired
    LoginRolesMapper loginRolesMapper;
    @Autowired
    LoginPermissionMapper loginPermissionMapper;

    @Override
    public void upDateById(Admin admin) {
        admin.setUpdateTime(new Date());


    }

    //根据用户名寻找admin
    @Override
    public List<Admin> findAdminByUsername(String username) {
        return loginMapper.findAdminByUsername(username);

    }

    @Override
    public Set<String> quaryByIds(Integer[] roleIds) {
        Set<String> rolesList = new HashSet<>();
        if(roleIds.length == 0){
            return rolesList;
        }

        for (int i = 0; i < roleIds.length; i++) {
            List<Role> roleList = loginRolesMapper.selectByRoleIds(roleIds[i]);
            rolesList.add(roleList.get(0).getName());
        }



        return rolesList;
    }

    @Override
    public Set<String> quaryByRoleIds(Integer[] roleIds) {
        Set<String> permissionList = new HashSet<>();
        if(roleIds.length == 0){
            return permissionList;
        }

        for (int i = 0; i < roleIds.length; i++) {
            List<Permission> permission = loginPermissionMapper.selectByIds(roleIds[i]);
            permissionList.add(permission.get(0).getPermission());
        }

        return permissionList;
    }



}
