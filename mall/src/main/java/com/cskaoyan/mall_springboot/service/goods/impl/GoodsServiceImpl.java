package com.cskaoyan.mall_springboot.service.goods.impl;

import com.cskaoyan.mall_springboot.bean.goods.*;
import com.cskaoyan.mall_springboot.bean.mallmg.Category;
import com.cskaoyan.mall_springboot.mapper.GoodsMapper;
import com.cskaoyan.mall_springboot.service.goods.GoodsService;
import org.apache.ibatis.session.SqlSessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zero
 * @Date: 2019/5/22 22:16
 * @Version 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    @Override
    public BaseResultVo selectGoodsList(int page, int limit, String sort, String order, String goodsSn, String name) {
        int total = goodsMapper.selectTotal(goodsSn, name);
        limit = total < limit ? total : limit;
        int offset = (page - 1) * (limit);
        List<Goods> goodsList = goodsMapper.selectGoodsListByPage(limit, offset, sort, order, goodsSn, name);

        BaseResultVo baseResultVo = new BaseResultVo();
        Data<Goods> goodsData = new Data<>();

        goodsData.setItems(goodsList);
        goodsData.setTotal(total);

        baseResultVo.setErrno(0);
        baseResultVo.setData(goodsData);
        baseResultVo.setErrmsg("成功");
        return baseResultVo;
    }

    @Override
    public BaseResultVo selectGoodsById(String id) {
        Goods goods = goodsMapper.selectGoodsById(id);
        List<Attribute> attributes = goodsMapper.selectAttributeById(id);
        List<Specification> specifications = goodsMapper.selectSpecificationById(id);
        List<Product> products = goodsMapper.selectProductById(id);

        Data<Object> data = new Data<>();
        data.setGoods(goods);
        data.setAttributes(attributes);
        data.setSpecifications(specifications);
        data.setProducts(products);

        int pid = goodsMapper.selectCategoryPidById(data.getGoods().getCategoryId());
        int[] categoryIds = {data.getGoods().getCategoryId(), pid};
        data.setCategoryIds(categoryIds);

        BaseResultVo baseResultVo = new BaseResultVo();
        baseResultVo.setErrno(0);
        baseResultVo.setData(data);
        baseResultVo.setErrmsg("成功");
        return baseResultVo;
    }

    @Override
    public BaseResultVo selectCatAndBrand() {
        //根据pid=0的条件查询出一级目录的id和name
        List<Category> categoryList = goodsMapper.selectCategory();
        //根据pid查到的id集合当作父目录id（也就是新的pid）查询二级目录的id和name并封装
        for (Category category : categoryList) {
            //将pid=0的id当作pid
            Integer pid = category.getValue();
            ArrayList<Category> categoryList1 = goodsMapper.selectChildrenByPid(pid);
            category.setChildren(categoryList1);
        }
        List<Brand> brandList = goodsMapper.selectBrand();
        Data<Object> data = new Data<>();
        data.setCategoryList(categoryList);
        data.setBrandList(brandList);
        BaseResultVo baseResultVo = new BaseResultVo();
        baseResultVo.setErrno(0);
        baseResultVo.setData(data);
        baseResultVo.setErrmsg("成功");
        return baseResultVo;
    }

    @Override
    @Transactional
    public BaseResultVo updateGoods(Data data) {
        BaseResultVo resultVo = new BaseResultVo();
        try {
            int goodsId = data.getGoods().getId();
            //通过goodsId更新attribute表中的相关信息
            List<Attribute> attributes = data.getAttributes();
            for (Attribute attribute : attributes) {
                goodsMapper.updateAttributeByGoodsId(attribute, goodsId);
            }
            //通过goodsId更新goods表中的相关信息
            Goods goods = data.getGoods();
            goodsMapper.updateGoodsByGoodsId(goods);
            //通过goodsId更新product表中的相关信息
            List<Product> products = data.getProducts();
            for (Product product : products) {
                System.out.println(product.getUpdateTime());
                System.out.println(product.getAddTime());
                goodsMapper.updateProductByGoodsId(product, goodsId);
            }
            //通过goodsId更新specification表中的相关信息
            List<Specification> specifications = data.getSpecifications();
            for (Specification specification : specifications) {
                if (specification.getId() != null) {
                    goodsMapper.updateSpecification(specification, goodsId);
                } else if (specification.getId() == null) {
                    goodsMapper.insertSpecification(specification, goodsId);
                }
            }
        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVo.setErrno(500);
            resultVo.setErrmsg("更新失败");
            return resultVo;
        }
        resultVo.setErrno(0);
        resultVo.setErrmsg("成功");
        return resultVo;
    }

    @Override
    public BaseResultVo deleteGoods(Goods goods) {
        BaseResultVo baseResultVo = new BaseResultVo();
        try {
            goodsMapper.deleteGoods(goods);
        } catch (Exception e) {
            e.printStackTrace();
        }
        baseResultVo.setErrno(0);
        baseResultVo.setErrmsg("成功");
        return baseResultVo;
    }

    @Override
    public BaseResultVo insertGoods(Data data) {
        BaseResultVo resultVo = new BaseResultVo();
        try {
            int goodsSn=Integer.parseInt(data.getGoods().getGoodsSn());
            //通过goodsSn新增attribute表中的相关信息
            List<Attribute> attributes = data.getAttributes();
            for (Attribute attribute : attributes) {
                goodsMapper.insertAttributeByGoodsSn(attribute, goodsSn);
            }
            //通过goodsSn新增goods表中的相关信息
            Goods goods = data.getGoods();
            int i = goodsMapper.selectIdByGoodsSn(goodsSn);
            if (i == 0) {
                goodsMapper.insertGoodsByGoodsSn(goods);
            }else {
                resultVo.setErrno(500);
                resultVo.setErrmsg("商品编号重复，请更换商品编号后继续添加");
                return resultVo;
            }

            //通过goodsSn新增product表中的相关信息
            List<Product> products = data.getProducts();
            for (Product product : products) {
                goodsMapper.insertProductByGoodsSn(product, goodsSn);
            }
            //通过goodsSn新增specification表中的相关信息
            List<Specification> specifications = data.getSpecifications();

            for (Specification specification : specifications) {
                if (specification.getId() != null) {
                    goodsMapper.updateSpecification(specification, goodsSn);
                } else if (specification.getId() == null) {
                    goodsMapper.insertSpecification(specification, goodsSn);
                }
            }
        } catch (SqlSessionException e) {
            e.printStackTrace();
            resultVo.setErrno(500);
            resultVo.setErrmsg("更新失败");
            return resultVo;
        }
        resultVo.setErrno(0);
        resultVo.setErrmsg("成功");
        return resultVo;
    }

    @Override
    public BaseResultVo getGoodsCount() {
        int total = goodsMapper.selectTotal(null,null);
        BaseResultVo resultVo = new BaseResultVo();
        Data<Object> data = new Data<>();
        data.setGoodsCount(total);
        resultVo.setData(data);
        resultVo.setErrmsg("成功");
        resultVo.setErrno(0);
        return resultVo;
    }

}
