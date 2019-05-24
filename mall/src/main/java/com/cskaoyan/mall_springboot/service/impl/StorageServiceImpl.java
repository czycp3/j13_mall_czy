package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.storage.Storage;
import com.cskaoyan.mall_springboot.mapper.StorageMapper;
import com.cskaoyan.mall_springboot.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/24 0024 上午 11:41
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    StorageMapper mapper;

    @Override
    public BaseQueryVo queryStorgeList(PageHelper pageHelper, String key, String name) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo resultVo = new ResultVo();
        pageHelper.setOffset();

        resultVo.setTotal(mapper.selectCountStorge());
        List items = mapper.queryStorgeList(pageHelper, key, name);
        resultVo.setItems(items);
        baseQueryVo.setData(resultVo);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");
        return baseQueryVo;
    }

    @Override
    public SingleQueryVo updateStorage(Storage storage) {
        SingleQueryVo singleQueryVo = new SingleQueryVo();

        boolean res = mapper.updateStorage(storage);
        singleQueryVo.setData(storage);
        singleQueryVo.setErrno(0);
        singleQueryVo.setErrmsg("成功");
        return singleQueryVo;
    }

    @Override
    public SingleQueryVo deleteStorage(Storage storage) {
        SingleQueryVo singleQueryVo = new SingleQueryVo();

        boolean res = mapper.deleteStorage(storage);
        singleQueryVo.setErrno(0);
        singleQueryVo.setErrmsg("成功");
        return singleQueryVo;
    }
}
