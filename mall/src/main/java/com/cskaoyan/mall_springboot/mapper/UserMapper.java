package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.user.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cly
 */
public interface UserMapper {

    /**
     * 统计会员总条目数
     * @return
     */
    int selectCounAlltUser(@Param("user") User user);

    /**
     * 查询会员列表
     * @param pageHelper
     * @return
     */
    List<User> selectAllUser(@Param("pageHelper") PageHelper pageHelper,@Param("user") User user);

    /**
     * 统计意见反馈列表总条目数
     * @param feedBack
     * @return
     */
    int selectCountAllFeedBack(@Param("feedback") FeedBack feedBack);

    /**
     * 查询反馈列表
     * @param pageHelper
     * @param feedBack
     * @return
     */
    List<FeedBack> selectAllFeedBack(@Param("pageHelper") PageHelper pageHelper, @Param("feedback") FeedBack feedBack);

    /**
     * 统计搜索历史总条目数
     * @param history
     * @return
     */
    int selectCountAllHistory(@Param("history") History history);

    /**
     * 查询搜索历史列表
     * @param pageHelper
     * @param history
     * @return
     */
    List<History> selectAllHistory(@Param("pageHelper") PageHelper pageHelper, @Param("history") History history);

    /**
     * 统计会员足迹总条目数
     * @param footPrint
     * @return
     */
    int selectCountAllFootPrint(@Param("footprint") FootPrint footPrint);

    /**
     * 查询会员足迹列表
     * @param pageHelper
     * @param footPrint
     * @return
     */
    List<FootPrint> selectAllFootPrint(@Param("pageHelper") PageHelper pageHelper, @Param("footprint") FootPrint footPrint);

    /**
     * 统计会员收藏总条目数
     * @param collect
     * @return
     */
    int selectCountAllCollect(@Param("collect") Collect collect);

    /**
     * 查询会员收藏列表
     * @param pageHelper
     * @param collect
     * @return
     */
    List<Collect> selectAllCollect(@Param("pageHelper") PageHelper pageHelper,@Param("collect") Collect collect);

    /**
     * 统计收货地址总条目数
     * @param address
     * @return
     */
    int selectCountAllAddress(Address address);

    /**
     * 查询收货地址列表
     * @param pageHelper
     * @param address
     * @return
     */
    List<Address> selectAllAddress(PageHelper pageHelper, Address address);
}
