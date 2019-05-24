package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.user.*;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cly
 */
@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //------会员管理------
    @RequestMapping("/user/list")
    @ResponseBody
    public BaseQueryVo userList(PageHelper pageHelper,User user){
        return userService.queryUserList(pageHelper,user);
    }

    //------会员足迹------
    @RequestMapping("/footprint/list")
    @ResponseBody
    public BaseQueryVo footprintList(PageHelper pageHelper, FootPrint footPrint){
        return userService.queryFootPrintList(pageHelper, footPrint);
    }

    //------收货地址------
    @RequestMapping("/address/list")
    @ResponseBody
    public BaseQueryVo addressList(PageHelper pageHelper, Address address){
        return userService.queryAddressList(pageHelper, address);
    }

    //------会员收藏------
    @RequestMapping("/collect/list")
    @ResponseBody
    public BaseQueryVo collectList(PageHelper pageHelper, Collect collect){
        return userService.queryCollectList(pageHelper, collect);
    }

    //------搜索历史------
    @RequestMapping("/history/list")
    @ResponseBody
    public BaseQueryVo historyList(PageHelper pageHelper, History history){
        return userService.queryHistoryList(pageHelper, history);
    }

    //------意见反馈------
    @RequestMapping("/feedback/list")
    @ResponseBody
    public BaseQueryVo feedbackList(PageHelper pageHelper, FeedBack feedBack){
        return userService.queryFeedBackList(pageHelper,feedBack);
    }

}
