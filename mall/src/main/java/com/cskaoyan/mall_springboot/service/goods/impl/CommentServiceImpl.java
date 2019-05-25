package com.cskaoyan.mall_springboot.service.goods.impl;

import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;
import com.cskaoyan.mall_springboot.bean.goods.Comment;
import com.cskaoyan.mall_springboot.bean.goods.Data;
import com.cskaoyan.mall_springboot.mapper.CommentMapper;
import com.cskaoyan.mall_springboot.service.goods.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/25 9:34
 * @Version 1.0
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public BaseResultVo selectCommentList(int page, int limit, String sort, String order, String userId,String valueId) {
        int total = commentMapper.selectTotal(userId, valueId);
        limit = total < limit ? total : limit;
        int offset = (page - 1) * (limit);
        List<Comment> commentList = commentMapper.selectCommentList(limit, offset, sort, order, userId, valueId);

        BaseResultVo baseResultVo = new BaseResultVo();
        Data<Comment> goodsData = new Data<>();

        goodsData.setItems(commentList);
        goodsData.setTotal(total);

        baseResultVo.setErrno(0);
        baseResultVo.setData(goodsData);
        baseResultVo.setErrmsg("成功");
        return baseResultVo;
    }

    @Override
    @Transactional
    public BaseResultVo replyOrder(String commentId, String content) {
        try {
            commentMapper.replyOrder(commentId,content);
        }catch (Exception e){
            e.printStackTrace();
        }
        BaseResultVo baseResultVo = new BaseResultVo();
        baseResultVo.setErrno(0);
        baseResultVo.setErrmsg("成功");
        return baseResultVo;
    }

    @Override
    @Transactional
    public BaseResultVo deleteComment(Comment comment) {
        try{
            commentMapper.deleteCommentById(comment.getId());
        }catch (Exception e){
            e.printStackTrace();
        }

        BaseResultVo baseResultVo = new BaseResultVo();
        baseResultVo.setErrno(0);
        baseResultVo.setErrmsg("成功");
        return baseResultVo;
    }
}
