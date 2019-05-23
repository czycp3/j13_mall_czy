package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.storage.Storage;
import com.cskaoyan.mall_springboot.bean.storage.StorageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StorageMapper {
    long countByExample(StorageExample example);

    int deleteByExample(StorageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Storage record);

    int insertSelective(Storage record);

    List<Storage> selectByExample(StorageExample example);

    Storage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByExample(@Param("record") Storage record, @Param("example") StorageExample example);

    int updateByPrimaryKeySelective(Storage record);

    int updateByPrimaryKey(Storage record);

    /**
     * 插入图片信息
     * @param storage
     * @return int
     */
    int insertStorage(Storage storage);

    /**
     * 按Key查询图片信息
     * @param storage
     * @return Storage
     */
    Storage selectByKey(Storage storage);
}