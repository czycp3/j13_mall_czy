package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.ResultVo;
import com.cskaoyan.mall_springboot.bean.ad.Ad;
import com.cskaoyan.mall_springboot.mapper.AdMapper;
import com.cskaoyan.mall_springboot.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Service
public class AdServiceImpl implements AdService {

    private AdMapper adMapper;

    @Autowired
    public AdServiceImpl(AdMapper adMapper) {
        this.adMapper = adMapper;
    }

    @Override
    public BaseQueryVo queryAllAdByPage(int page, int limit, String sort, String order) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<Ad> resultVo = new ResultVo<>();
        //查询custom总记录数
        int total = adMapper.selectCountAd();
        int offset = (page - 1) * limit;
        List<Ad> adList =  adMapper.queryAllAdByPage(limit,offset);

        resultVo.setItems(adList);
        resultVo.setTotal(total);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");

        baseQueryVo.setData(resultVo);
        return baseQueryVo;
    }
}
