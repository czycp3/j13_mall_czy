package com.cskaoyan.mall_springboot.mapper.login;

import com.cskaoyan.mall_springboot.bean.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-23 22:58
 */
public interface LoginMapper {

    //根据用户名寻找admin
    List<Admin> findAdminByUsername(@Param("username") String username);





}
