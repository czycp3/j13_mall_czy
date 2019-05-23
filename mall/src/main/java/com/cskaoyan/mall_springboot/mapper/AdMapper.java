package com.cskaoyan.mall_springboot.mapper;


import com.cskaoyan.mall_springboot.bean.ad.Ad;
import com.cskaoyan.mall_springboot.bean.ad.AdExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdMapper {
    long countByExample(AdExample example);

    int deleteByExample(AdExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Ad record);

    int insertSelective(Ad record);

    List<Ad> selectByExample(AdExample example);

    Ad selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Ad record, @Param("example") AdExample example);

    int updateByExample(@Param("record") Ad record, @Param("example") AdExample example);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);

    /**
     * 查询广告总数
     * @param name
     * @param content
     * @return int
     */
    int selectCountAd(String name,String content);

    /**
     * 分页查询广告
     * @param limit 每页数量
     * @param offset 偏移量
     * @param sort 排序字段
     * @param order 排序方式
     * @param name
     * @param content
     * @return List<Ad>
     */
    List<Ad> queryAllAdByPage(@Param("limit") int limit, @Param("offset") int offset,
                              @Param("sort") String sort,@Param("order") String order,
                              @Param("name") String name,@Param("content") String content);


}