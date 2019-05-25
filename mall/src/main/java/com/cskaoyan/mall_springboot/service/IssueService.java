package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.mallmg.Issue;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;

public interface IssueService {
    BaseQueryVo<Issue> SelectIssue(MallPageHelper mallPageHelper);

    SingleQueryVo<Issue> InsertIssue(Issue issue);

    SingleQueryVo<Issue> UpdateIssue(Issue issue);

    SingleQueryVo<Issue> DeleteIssue(Issue issue);
}
