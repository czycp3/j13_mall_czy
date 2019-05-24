package com.cskaoyan.mall_springboot.mapper.goodsmapper;

import com.cskaoyan.mall_springboot.bean.goods.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/22 22:17
 * @Version 1.0
 */

public interface GoodsMapper {
    Goods selectGoodsById(@Param("id") String id);

    int selectCategoryPidById(@Param("categoryId") int categoryId);

    int selectTotal();

    List<Goods> selectGoodsListByPage(@Param("limit") int limit, @Param("offset")int offset, @Param("sort") String sort, @Param("order") String order);

    List<Attribute> selectAttributeById(@Param("id")String id);

    List<Specification> selectSpecificationById(@Param("id")String id);

    List<Product> selectProductById(@Param("id")String id);
}
