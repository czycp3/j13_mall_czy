package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.BaseQueryVo;
import org.springframework.stereotype.Service;

/**
 * @author CZY-Y7000P
 */
@Service
public interface AdService {
    /**
     * 分页查询所有广告
     * @param page
     * @param limit
     * @param sort
     * @param order
     * @return BaseQueryVo
     */
    BaseQueryVo queryAllAdByPage(int page, int limit, String sort, String order);
}
