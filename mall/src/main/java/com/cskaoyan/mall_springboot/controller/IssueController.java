package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.mallmg.Issue;
import com.cskaoyan.mall_springboot.bean.mallmg.MallPageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issue")
public class IssueController {
    @Autowired
    IssueService issueService;
    @RequestMapping("/list")
    public BaseQueryVo<Issue> ListController(MallPageHelper mallPageHelper){
        BaseQueryVo<Issue> issueBaseQueryVo = issueService.SelectIssue(mallPageHelper);
        return issueBaseQueryVo;
    }
    @RequestMapping("/create")
    public SingleQueryVo<Issue> CreateController(@RequestBody Issue issue){
        SingleQueryVo<Issue> singleQueryVo=issueService.InsertIssue(issue);
        return singleQueryVo;
    }
    @RequestMapping("/update")
    public SingleQueryVo<Issue> UpdateController(@RequestBody Issue issue){
        SingleQueryVo<Issue> singleQueryVo = issueService.UpdateIssue(issue);
        return singleQueryVo;
    }
    @RequestMapping("/delete")
    public SingleQueryVo<Issue> DeleteController(@RequestBody Issue issue){
        SingleQueryVo<Issue> singleQueryVo = issueService.DeleteIssue(issue);
        return singleQueryVo;
    }
}
