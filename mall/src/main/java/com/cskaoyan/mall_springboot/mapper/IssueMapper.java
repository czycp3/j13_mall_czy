package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.mallmg.Issue;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

@Mapper
public interface IssueMapper {
    Integer SelectIssueCount();

    ArrayList<Issue> SelectIssueList(@Param("pageHelper") MallPageHelper mallPageHelper,@Param("offset") int offset);

    Integer InsertIssue(@Param("issue") Issue issue);

    Issue SelectIssueByIssue(@Param("issue") Issue issue);

    int UpdateIssue(@Param("issue") Issue issue);

    int DeleteIssueById(@Param("id") Integer id);
}
