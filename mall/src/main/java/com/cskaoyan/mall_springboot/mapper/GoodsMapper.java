package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.goods.*;
import com.cskaoyan.mall_springboot.bean.mallmg.Category;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @Author: zero
 * @Date: 2019/5/22 22:17
 * @Version 1.0
 */

public interface GoodsMapper {
    Goods selectGoodsById(@Param("id") String id);

    int selectCategoryPidById(@Param("categoryId") int categoryId);

    int selectTotal(@Param("goodsSn") String goodsSn, @Param("name") String name);

    List<Goods> selectGoodsListByPage(@Param("limit") int limit, @Param("offset") int offset, @Param("sort") String sort, @Param("order") String order, @Param("goodsSn") String goodsSn, @Param("name") String name);

    List<Attribute> selectAttributeById(@Param("id")String id);

    List<Specification> selectSpecificationById(@Param("id")String id);

    List<Product> selectProductById(@Param("id")String id);

    List<Category> selectCategory();

    List<Brand> selectBrand();

    ArrayList<Category> selectChildrenByPid(@Param("pid") Integer pid);

    void updateAttributeByGoodsId(@Param("attribute") Attribute attribute, @Param("goodsId") int goodsId);

    void updateGoodsByGoodsId(@Param("goods")Goods goods);

    void updateProductByGoodsId(@Param("product")Product product, @Param("goodsId")int goodsId);

    void updateSpecification(@Param("specification") Specification specification, @Param("goodsId")int goodsId);

    void insertSpecification(@Param("specification") Specification specification, @Param("goodsId")int goodsId);

    void deleteGoods(@Param("goods") Goods goods);

    void insertAttributeByGoodsSn(@Param("attribute") Attribute attribute, @Param("goodsSn")int goodsSn);

    void insertGoodsByGoodsSn(@Param("goods") Goods goods);

    void insertProductByGoodsSn(@Param("product")Product product, @Param("goodsSn")int goodsSn);

    int selectIdByGoodsSn(@Param("goodsSn")int goodsSn);

    /**
     * 查询热门商品
     * @author CZY
     * @return List<Goods>
     */
    List<Goods> queryHotGoods();

    /**
     * 按品牌查询商品数量
     * @param id
     * @return int
     */
    int queryCountByBrandId(int id);

    /**
     * 按品牌分页查询商品
     * @param offset
     * @param size
     * @param id
     * @return Goods[]
     */
    Goods[] queryGoodsByBrandId(@Param("offset") int offset, @Param("size") int size, @Param("id") int id);

    /**
     * 查询热门商品
     * @author CZY
     * @return List<Goods>
     */
    List<Goods> queryNewGoods();

    void createAttributeByGoodsId(@Param("attribute") Attribute attribute, @Param("goodsId") int goodsId);

    Set<Integer> selectIdListByGoodsId(@Param("goodsId") int goodsId);

    void deleteAttributeById(@Param("id") int id);
}
