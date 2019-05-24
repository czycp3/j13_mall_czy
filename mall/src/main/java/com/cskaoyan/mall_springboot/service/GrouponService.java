package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.groupon.Groupon;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.util.PageUtil;

/**
 * @author CZY-Y7000P
 */
public interface GrouponService {
    /**
     * 分页查询团购规则
     * @param pu
     * @param groupon
     * @return BaseQueryVo
     */
    BaseQueryVo queryAllGrouponByPage(PageUtil pu, Groupon groupon);

    /**
     * 更新团购规则
     * @param groupon
     * @return SingleQueryVo
     */
    SingleQueryVo updateGroupon(Groupon groupon);

    /**
     * 删除团购规则
     * @param groupon
     * @return SingleQueryVo
     */
    SingleQueryVo deleteGroupon(Groupon groupon);

    /**
     * 插入团购规则
     * @param groupon
     * @return
     */
    SingleQueryVo create(Groupon groupon);
}
