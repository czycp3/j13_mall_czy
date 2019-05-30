package com.cskaoyan.mall_springboot.mapper.login;

import com.cskaoyan.mall_springboot.bean.system.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-25 10:01
 */
public interface LoginRolesMapper {
    List<Role> selectByRoleIds(@Param("roleId") Integer roleId);
}
