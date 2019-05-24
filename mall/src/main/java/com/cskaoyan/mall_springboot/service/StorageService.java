package com.cskaoyan.mall_springboot.service;
import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.SingleQueryVo;
import com.cskaoyan.mall_springboot.bean.storage.Storage;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/24 0024 上午 11:40
 */
public interface StorageService {
    BaseQueryVo queryStorgeList(PageHelper pageHelper, String key, String name);
    SingleQueryVo updateStorage(Storage storage);

    SingleQueryVo deleteStorage(Storage storage);
}
