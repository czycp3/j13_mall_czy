package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.mallmg.Keyword;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface KeywordMapper {
    int SelectKeywordCount();

    ArrayList<Keyword> SelectKeywordList(@Param("mallPageHelper") MallPageHelper mallPageHelper,@Param("offset") int offset);

    int InsertKeyword(@Param("keyword") Keyword keyword);

    Keyword SelectKeywordByAddTime(@Param("addTime") String addTime);

    int UpdateKeyword(@Param("keyword") Keyword keyword);

    int DeleteKeyword(@Param("id") Integer id);
}
