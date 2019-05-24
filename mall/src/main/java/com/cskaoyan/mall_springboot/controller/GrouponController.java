package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.groupon.Groupon;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.service.GrouponService;
import com.cskaoyan.mall_springboot.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author CZY-Y7000P
 */
@Controller
public class GrouponController {

    private GrouponService grouponService;

    @Autowired
    public GrouponController(GrouponService grouponService) {
        this.grouponService = grouponService;
    }

    @RequestMapping("/groupon/list")
    @ResponseBody
    public BaseQueryVo list(PageUtil pu, Groupon groupon) {
        return grouponService.queryAllGrouponByPage(pu, groupon);
    }

    @RequestMapping("/groupon/update")
    @ResponseBody
    public SingleQueryVo update(@RequestBody Groupon groupon) {
        return grouponService.updateGroupon(groupon);
    }

    @RequestMapping("/groupon/delete")
    @ResponseBody
    public SingleQueryVo delete(@RequestBody Groupon groupon) {
        return grouponService.deleteGroupon(groupon);
    }

    @RequestMapping("/groupon/create")
    @ResponseBody
    public SingleQueryVo create(@RequestBody Groupon groupon) {
        return grouponService.create(groupon);
    }
}


