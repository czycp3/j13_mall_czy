package com.cskaoyan.mall_springboot.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @Author: 弟中弟
 * @Date: 2019/5/23 0023 下午 8:02
 */
public class StringIntArrayHandler extends BaseTypeHandler<Integer[]> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Integer[] o, JdbcType jdbcType) throws SQLException {
        //bean转为数据库类型
        //第一个参数为需要转换的数据在数据库中的列数
        String s = Arrays.toString(o);
        preparedStatement.setString(i, s);
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, String columnLabel) throws SQLException {
        //数据库类型转换为bean
        String s = resultSet.getString(columnLabel);
        s = s.substring(1,s.length()-1);
        String[] split = s.split("\\D");
        Integer[] ints = new Integer[split.length];
        for(int i=0;i<split.length;i++){
            ints[i] = Integer.parseInt(split[i]);
        }
        return ints;
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Integer[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
