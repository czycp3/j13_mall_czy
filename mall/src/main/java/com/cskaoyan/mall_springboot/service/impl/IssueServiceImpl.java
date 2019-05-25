package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.mallmg.Issue;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.mapper.IssueMapper;
import com.cskaoyan.mall_springboot.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class IssueServiceImpl implements IssueService {
    @Autowired
    IssueMapper issueMapper;
    @Override
    public BaseQueryVo<Issue> SelectIssue(MallPageHelper mallPageHelper) {
        ResultVo<Issue> issueResultVo = new ResultVo<>();
        BaseQueryVo<Issue> issueBaseQueryVo = new BaseQueryVo<>();
        int offset = mallPageHelper.getOffset();
        Integer integer = issueMapper.SelectIssueCount();
        ArrayList<Issue> issues =  issueMapper.SelectIssueList(mallPageHelper,offset);
        issueResultVo.setTotal(integer);
        issueResultVo.setItems(issues);
        issueBaseQueryVo.setData(issueResultVo);
        issueBaseQueryVo.setErrmsg("成功");
        issueBaseQueryVo.setErrno(0);
        return issueBaseQueryVo;
    }

    @Override
    public SingleQueryVo<Issue> InsertIssue(Issue issue) {
        SingleQueryVo<Issue> singleQueryVo = new SingleQueryVo<>();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        issue.setAddTime(format);
        Integer integer = issueMapper.InsertIssue(issue);
        Issue issue1 = issueMapper.SelectIssueByIssue(issue);
        singleQueryVo.setErrno(0);
        singleQueryVo.setErrmsg("成功");
        singleQueryVo.setData(issue1);
        return singleQueryVo;
    }

    @Override
    public SingleQueryVo<Issue> UpdateIssue(Issue issue) {
        SingleQueryVo<Issue> singleQueryVo = new SingleQueryVo<>();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        issue.setUpdateTime(format);
        int i =issueMapper.UpdateIssue(issue);
        singleQueryVo.setData(issue);
        singleQueryVo.setErrmsg("成功");
        singleQueryVo.setErrno(0);
        return singleQueryVo;
    }

    @Override
    public SingleQueryVo<Issue> DeleteIssue(Issue issue) {
        int i = issueMapper.DeleteIssueById(issue.getId());
        SingleQueryVo<Issue> singleQueryVo = new SingleQueryVo<>();
        if (i>0){
            singleQueryVo.setErrno(0);
            singleQueryVo.setErrmsg("成功");
        }
        return singleQueryVo;
    }
}
