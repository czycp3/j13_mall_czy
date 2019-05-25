package com.cskaoyan.mall_springboot.service.goods;

import com.cskaoyan.mall_springboot.bean.goods.BaseResultVo;
import com.cskaoyan.mall_springboot.bean.goods.Comment;

/**
 * @Author: zero
 * @Date: 2019/5/25 9:32
 * @Version 1.0
 */
public interface CommentService {
    BaseResultVo selectCommentList(int page, int limit, String sort, String order, String userId, String valueId);


    BaseResultVo replyOrder(String commentId, String content);

    BaseResultVo deleteComment(Comment id);
}
