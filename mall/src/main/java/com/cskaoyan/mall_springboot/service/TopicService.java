package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.topic.Topic;
import com.cskaoyan.mall_springboot.util.PageUtil;

/**
 * @author CZY-Y7000P
 */
public interface TopicService {
    /**
     * 分页查找所有topic
     * @param pu
     * @param topic
     * @return BaseQueryVo
     */
    BaseQueryVo queryAllTopicByPage(PageUtil pu, Topic topic);

    /**
     * 更新专题
     * @param topic
     * @return SingleQueryVo
     */
    SingleQueryVo updateTopic(Topic topic);

    /**
     * 删除topic
     * @param topic
     * @return SingleQueryVo
     */
    SingleQueryVo deleteTopic(Topic topic);

    /**
     * 新增topic
     * @param topic
     * @return SingleQueryVo
     */
    SingleQueryVo create(Topic topic);
}
