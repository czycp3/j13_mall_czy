package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.topic.Topic;
import com.cskaoyan.mall_springboot.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
public interface TopicMapper {
    /**
     * 查询topic数量
     * @param topic
     * @return int
     */
    int selectCountTopic(@Param("topic") Topic topic);

    /**
     * 分页查询topic
     * @param pu
     * @param topic
     * @return List<Topic>
     */
    List<Topic> queryAllTopicByPage(@Param("pu") PageUtil pu, @Param("topic") Topic topic);

    /**
     * 更新topic
     * @param topic
     * @return 成功行数
     */
    int updateByPrimaryKeySelective(Topic topic);

    /**
     * 按主键查询topic
     * @param id
     * @return Topic
     */
    Topic selectByPrimaryKey(int id);
}
