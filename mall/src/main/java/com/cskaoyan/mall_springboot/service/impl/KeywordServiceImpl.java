package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.mallmg.Keyword;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.mapper.KeywordMapper;
import com.cskaoyan.mall_springboot.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class KeywordServiceImpl implements KeywordService {
    @Autowired
    KeywordMapper keywordMapper;
    @Override
    public BaseQueryVo<Keyword> SelectKeyword(MallPageHelper mallPageHelper) {
        int offset = mallPageHelper.getOffset();
        BaseQueryVo<Keyword> baseQueryVo = new BaseQueryVo<Keyword>();
        ResultVo<Keyword> keywordResultVo = new ResultVo<>();
        int i = keywordMapper.SelectKeywordCount();
        ArrayList<Keyword> keywords = keywordMapper.SelectKeywordList(mallPageHelper,offset);
        keywordResultVo.setItems(keywords);
        keywordResultVo.setTotal(i);
        baseQueryVo.setErrmsg("成功");
        baseQueryVo.setErrno(0);
        baseQueryVo.setData(keywordResultVo);
        return baseQueryVo;
    }

    @Override
    public SingleQueryVo<Keyword> InsertKeyword(Keyword keyword) {
        SingleQueryVo<Keyword> keywordSingleQueryVo = new SingleQueryVo<>();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        keyword.setAddTime(format);
        int i = keywordMapper.InsertKeyword(keyword);
        Keyword keyword1 = keywordMapper.SelectKeywordByAddTime(keyword.getAddTime());
        keywordSingleQueryVo.setData(keyword1);
        keywordSingleQueryVo.setErrno(0);
        keywordSingleQueryVo.setErrmsg("成功");
        return keywordSingleQueryVo;
    }

    @Override
    public SingleQueryVo<Keyword> UpdateKeyword(Keyword keyword) {
        SingleQueryVo<Keyword> keywordSingleQueryVo = new SingleQueryVo<>();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        keyword.setUpdateTime(format);
        int i = keywordMapper.UpdateKeyword(keyword);
        keywordSingleQueryVo.setData(keyword);
        keywordSingleQueryVo.setErrno(0);
        keywordSingleQueryVo.setErrmsg("成功");
        return keywordSingleQueryVo;
    }

    @Override
    public SingleQueryVo DeleteKeyword(Keyword keyword) {
        SingleQueryVo<Object> objectSingleQueryVo = new SingleQueryVo<>();
        int i = keywordMapper.DeleteKeyword(keyword.getId());
        if (i>0){
            objectSingleQueryVo.setErrmsg("成功");
            objectSingleQueryVo.setErrno(0);
        }
        return objectSingleQueryVo;
    }
}
