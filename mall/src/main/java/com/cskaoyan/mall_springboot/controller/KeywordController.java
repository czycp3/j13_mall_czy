package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.mallmg.Keyword;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RequestMapping("/keyword")
@RestController
public class KeywordController {
    @Autowired
    KeywordService keywordService;
    @RequestMapping("/list")
    public BaseQueryVo<Keyword> SelectKeyword(MallPageHelper mallPageHelper){
        BaseQueryVo<Keyword> baseQueryVo = keywordService.SelectKeyword(mallPageHelper);
        return baseQueryVo;
    }
    @RequestMapping("/create")
    public SingleQueryVo<Keyword> InsertKeyword(@RequestBody Keyword keyword){
      SingleQueryVo<Keyword> keywordSingleQueryVo =  keywordService.InsertKeyword(keyword);
      return keywordSingleQueryVo;
    }
    @RequestMapping("/update")
    public SingleQueryVo<Keyword> UpdateKeyword(@RequestBody Keyword keyword){
        SingleQueryVo<Keyword> keywordSingleQueryVo =  keywordService.UpdateKeyword(keyword);
        return keywordSingleQueryVo;
    }
    @RequestMapping("/delete")
    public SingleQueryVo DeleteKeyword(@RequestBody Keyword keyword){
        SingleQueryVo singleQueryVo =keywordService.DeleteKeyword(keyword);
        return singleQueryVo;
    }
}
