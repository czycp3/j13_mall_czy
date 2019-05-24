package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.system.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/22 0022 下午 10:01
 */
public interface RoleMapper {
    List<Role> queryRoleList(@Param("pg") PageHelper pageHelper,@Param("name") String name);

    int selectCountRole();

    boolean roleUpdate(Role role);

    boolean roleDelete(Role role);

    boolean roleInsert(Role role);

    Role queryRoleById(int id);
}
