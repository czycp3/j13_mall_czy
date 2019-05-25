package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;
import com.cskaoyan.mall_springboot.bean.goods.Comment;
import com.cskaoyan.mall_springboot.service.goods.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zero
 * @Date: 2019/5/25 9:30
 * @Version 1.0
 */
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/comment/list")
    @ResponseBody
    public BaseResultVo selectCommentList(int page,int limit,String sort,String order, String userId,String valueId){
        BaseResultVo baseResultVo = commentService.selectCommentList(page,limit,sort,order,userId,valueId);
        return baseResultVo;
    }

    @RequestMapping("/order/reply")
    @ResponseBody
    public BaseResultVo replyOrder(String commentId,String content){
        BaseResultVo baseResultVo = commentService.replyOrder(commentId,content);
        return baseResultVo;
    }

    @RequestMapping("/comment/delete")
    @ResponseBody
    public BaseResultVo deleteComment(Comment comment){
        BaseResultVo baseResultVo = commentService.deleteComment(comment);
        return baseResultVo;
    }

}
