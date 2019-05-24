package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.topic.Topic;
import com.cskaoyan.mall_springboot.service.TopicService;
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
public class TopicController {

    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping("/topic/list")
    @ResponseBody
    public BaseQueryVo list(PageUtil pu, Topic topic){
        return topicService.queryAllTopicByPage(pu,topic);
    }

    @RequestMapping("/topic/update")
    @ResponseBody
    public SingleQueryVo update(@RequestBody Topic topic){
        return topicService.updateTopic(topic);
    }

    @RequestMapping("/topic/delete")
    @ResponseBody
    public SingleQueryVo delete(@RequestBody Topic topic){
        return topicService.deleteTopic(topic);
    }

    @RequestMapping("/topic/create")
    @ResponseBody
    public SingleQueryVo create(@RequestBody Topic topic) {
        return topicService.create(topic);
    }
}
