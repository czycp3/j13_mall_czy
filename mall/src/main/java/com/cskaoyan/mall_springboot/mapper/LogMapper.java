package com.cskaoyan.mall_springboot.mapper;

import com.cskaoyan.mall_springboot.bean.Log;
import com.cskaoyan.mall_springboot.bean.PageHelper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/24 0024 上午 9:17
 */
public interface LogMapper {
    int selectCountLog();

    List<Log> queryLogList(@Param("pg") PageHelper pageHelper,@Param("name") String name);

}
