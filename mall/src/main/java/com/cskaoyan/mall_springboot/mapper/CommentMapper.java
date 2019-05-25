package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.goods.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/25 9:35
 * @Version 1.0
 */
public interface CommentMapper {
    int selectTotal(@Param("userId") String userId, @Param("valueId") String valueId);

    List<Comment> selectCommentList(@Param("limit") int limit, @Param("offset") int offset, @Param("sort") String sort, @Param("order") String order, @Param("userId") String userId, @Param("valueId") String valueId);

    void deleteCommentById(@Param("id") Integer id);

    void replyOrder(@Param("commentId") String commentId, @Param("content") String content);
}
