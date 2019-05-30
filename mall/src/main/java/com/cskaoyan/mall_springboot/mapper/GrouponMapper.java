package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.groupon.Groupon;
import com.cskaoyan.mall_springboot.bean.wx.GrouponList;
import com.cskaoyan.mall_springboot.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author CZY-Y7000P
 */
public interface GrouponMapper {
    /**
     * 条件查询团购规则条目数
     * @param groupon
     * @return int
     */
    int selectCountGroupon(Groupon groupon);

    /**
     * 分页查询团购规则
     * @param pu
     * @param groupon
     * @return List<Groupon>
     */
    List<Groupon> queryAllGrouponByPage(@Param("pu") PageUtil pu, @Param("groupon") Groupon groupon);

    /**
     * 更新groupon
     * @param groupon
     * @return int
     */
    int updateByPrimaryKeySelective(Groupon groupon);

    /**
     * 按ID 查询团购信息
     * @param id
     * @return Groupon
     */
    Groupon selectByPrimaryKey(int id);

    /**
     * 新增团购规则
     * @param groupon
     * @return int
     */
    int insertSelective(@Param("groupon") Groupon groupon);

    /**
     * 查询团购活动（WX）
     * @return List<GrouponList>
     */
    List<GrouponList> queryGroupon();
}
