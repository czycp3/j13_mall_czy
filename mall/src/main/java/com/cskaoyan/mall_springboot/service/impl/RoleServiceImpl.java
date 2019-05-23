package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.system.Role;
import com.cskaoyan.mall_springboot.mapper.RoleMapper;
import com.cskaoyan.mall_springboot.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/22 0022 下午 10:02
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper mapper;

    @Override
    public BaseQueryVo queryRoleList(PageHelper pageHelper,String name) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<Role> resultVo = new ResultVo<>();

        //查询custom总记录数
        resultVo.setTotal(mapper.selectCountRole());
        int offset = pageHelper.getOffset();
        resultVo.setItems(mapper.queryRoleList(pageHelper.getLimit(),offset,name));
        baseQueryVo.setData(resultVo);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");
        return baseQueryVo;
    }

    @Override
    public BaseQueryVo roleUpdate(Role role) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        boolean res = mapper.roleUpdate(role);
        System.out.println(res);
        System.out.println(role);
        baseQueryVo.setErrmsg("成功");
        baseQueryVo.setErrno(0);
        return baseQueryVo;
    }

    @Override
    public BaseQueryVo roleDelete(Role role) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        boolean res = mapper.roleDelete(role);
        System.out.println(res);
        baseQueryVo.setErrmsg("成功");
        baseQueryVo.setErrno(0);
        return baseQueryVo;
    }

    @Override
    public SingleQueryVo roleInsert(Role role) {
        SingleQueryVo singleQueryVo = new SingleQueryVo();
        try {
            boolean res = mapper.roleInsert(role);
            if (res == true) {
                role = mapper.queryRoleById(role.getId());
                singleQueryVo.setData(role);
                singleQueryVo.setErrmsg("成功");
                singleQueryVo.setErrno(0);
            }
        } catch (Exception e){
            singleQueryVo.setErrmsg("增加失败");
            singleQueryVo.setErrno(1);
            throw new RuntimeException(e);
        } finally {
            return singleQueryVo;
        }
    }
}
