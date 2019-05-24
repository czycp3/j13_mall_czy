package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.topic.Topic;
import com.cskaoyan.mall_springboot.mapper.TopicMapper;
import com.cskaoyan.mall_springboot.service.TopicService;
import com.cskaoyan.mall_springboot.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
@Service
public class TopicServiceImpl implements TopicService {

    private TopicMapper topicMapper;

    @Autowired
    public TopicServiceImpl(TopicMapper topicMapper) {
        this.topicMapper = topicMapper;
    }

    /**
     * 分页查询专题
     * @param pu
     * @param topic
     * @return BaseQueryVo
     */
    @Override
    public BaseQueryVo queryAllTopicByPage(PageUtil pu, Topic topic) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<Topic> resultVo = new ResultVo<>();
        String title = topic.getTitle();
        String subtitle = topic.getSubtitle();
        if (title != null) {
            title = "%" + title + "%";
            topic.setTitle(title);
        }
        if (subtitle != null) {
            subtitle = "%" + subtitle + "%";
            topic.setSubtitle(subtitle);
        }

        int total = topicMapper.selectCountTopic(topic);
        pu.setOffset();

        List<Topic> topicList = topicMapper.queryAllTopicByPage(pu,topic);

        resultVo.setItems(topicList);
        resultVo.setTotal(total);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");

        baseQueryVo.setData(resultVo);
        return baseQueryVo;
    }

    /**
     * 更新专题
     * @param topic
     * @return SingleQueryVo
     */
    @Override
    public SingleQueryVo updateTopic(Topic topic) {
        SingleQueryVo<Topic> singleQueryVo = new SingleQueryVo<>();
        try {
            int ret =  topicMapper.updateByPrimaryKeySelective(topic);
            if(ret != 0){
                Topic topic1 = topicMapper.selectByPrimaryKey(topic.getId());
                singleQueryVo.setData(topic1);
                singleQueryVo.setErrmsg("成功");
                singleQueryVo.setErrno(0);
            }
        }catch (Exception e){
            singleQueryVo.setErrmsg("更新失败");
            throw new RuntimeException(e);
        }
        return singleQueryVo;
    }
}
