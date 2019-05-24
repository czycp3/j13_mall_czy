package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.Log;
import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.mapper.LogMapper;
import com.cskaoyan.mall_springboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/24 0024 上午 9:18
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogMapper mapper;


    @Override
    public BaseQueryVo queryLogList(PageHelper pageHelper, String name) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<Log> resultVo = new ResultVo<>();
        pageHelper.setOffset();

        resultVo.setTotal(mapper.selectCountLog());
        resultVo.setItems(mapper.queryLogList(pageHelper,name));
        baseQueryVo.setErrmsg("成功");
        baseQueryVo.setErrno(0);
        baseQueryVo.setData(resultVo);
        return baseQueryVo;
    }
}
