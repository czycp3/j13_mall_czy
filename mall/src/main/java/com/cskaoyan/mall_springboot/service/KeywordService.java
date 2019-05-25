package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.mallmg.Keyword;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;

import java.util.ArrayList;

public interface KeywordService {
    BaseQueryVo<Keyword> SelectKeyword(MallPageHelper mallPageHelper);

    SingleQueryVo<Keyword> InsertKeyword(Keyword keyword);

    SingleQueryVo<Keyword> UpdateKeyword(Keyword keyword);

    SingleQueryVo DeleteKeyword(Keyword keyword);
}
