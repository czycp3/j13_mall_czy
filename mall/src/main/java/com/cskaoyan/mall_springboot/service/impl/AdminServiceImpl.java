package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.Admin;
import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.mapper.AdminMapper;
import com.cskaoyan.mall_springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/23 0023 下午 3:19
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper mapper;

    @Override
    public BaseQueryVo queryAdminList(PageHelper pageHelper, String name) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<Admin> resultVo = new ResultVo<>();
        pageHelper.setOffset();

        //查询总记录数
        resultVo.setTotal(mapper.selectCountAdmin());
        int offset = pageHelper.getOffset();
        List<Admin> items = mapper.queryAdminList(pageHelper, name);
        resultVo.setItems(items);
        baseQueryVo.setData(resultVo);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");
        return baseQueryVo;
    }
}
