package com.cskaoyan.mall_springboot.service;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.user.*;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;

/**
 * @author cly
 */
public interface UserService {

    /**
     * 查询会员列表
     * @param pageHelper
     * @return
     */
    BaseQueryVo queryUserList(PageHelper pageHelper,User user);

    /**
     * 查询反馈列表
     * @param pageHelper
     * @param feedBack
     * @return
     */
    BaseQueryVo queryFeedBackList(PageHelper pageHelper, FeedBack feedBack);

    /**
     * 查询搜索历史列表
     * @param pageHelper
     * @param history
     * @return
     */
    BaseQueryVo queryHistoryList(PageHelper pageHelper, History history);

    /**
     * 查询会员足迹列表
     * @param pageHelper
     * @param footPrint
     * @return
     */
    BaseQueryVo queryFootPrintList(PageHelper pageHelper, FootPrint footPrint);

    /**
     * 查询会员收藏列表
     * @param pageHelper
     * @param collect
     * @return
     */
    BaseQueryVo queryCollectList(PageHelper pageHelper, Collect collect);

    /**
     * 查询收货地址列表
     * @param pageHelper
     * @param address
     * @return
     */
    BaseQueryVo queryAddressList(PageHelper pageHelper, Address address);
}
