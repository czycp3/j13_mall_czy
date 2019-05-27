package com.cskaoyan.mall_springboot.mapper.login;

import com.cskaoyan.mall_springboot.bean.system.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther 芮狼Dan
 * @date 2019-05-25 10:02
 */
public interface LoginPermissionMapper {
    List<Permission> selectByIds(@Param("roleId") Integer roleId);
}
