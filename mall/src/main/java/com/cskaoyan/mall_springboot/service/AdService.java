package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.ad.Ad;
import com.cskaoyan.mall_springboot.bean.storage.Storage;
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
     * @param name
     * @param content
     * @return BaseQueryVo
     */
    BaseQueryVo queryAllAdByPage(int page, int limit, String sort, String order,String name,String content);

    /**
     * 更新广告信息
     * @param ad
     * @return SingleQueryVo
     */
    SingleQueryVo updateAd(Ad ad);

    /**
     * 删除广告信息
     * @param ad
     * @return SingleQueryVo
     */
    SingleQueryVo deleteAd(Ad ad);

    /**
     * 插入广告
     * @param ad
     * @return
     */
    SingleQueryVo create(Ad ad);

    /**
     * 插入上传图片信息
     * @param storage
     * @return SingleQueryVo
     */
    SingleQueryVo uploadImage(Storage storage);
}
