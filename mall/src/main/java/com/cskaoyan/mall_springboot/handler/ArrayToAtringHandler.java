package com.cskaoyan.mall_springboot.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @auther 芮狼Dan
 * @date 2019-05-25 11:10
 */
public class ArrayToAtringHandler extends BaseTypeHandler<Integer[]> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Integer[] integers, JdbcType jdbcType) throws SQLException {
        //javabean的类型转换成数据库
        //第一个参数是你需要转换的数据所在数据库表的列数


    }

    //将数据库类型转换成javabean类型
    @Override
    public Integer[] getNullableResult(ResultSet resultSet, String role_ids) throws SQLException {
        String rolId = resultSet.getString("role_ids");
        rolId = rolId.substring(1, rolId.length() - 1);
        if (rolId.length() == 1){
            Integer[] rolIdsList = new  Integer[1];
            rolIdsList[0] = Integer.parseInt(rolId);
            return rolIdsList;
        } else {
            String[] rolIdsStringList = rolId.split(",");
            Integer[] rolIdsList = new  Integer[rolIdsStringList.length];
            for (int i = 0; i < rolIdsStringList.length; i++) {
                rolIdsList[i] = Integer.parseInt(rolIdsStringList[i]);
            }
            return rolIdsList;
        }
    }

    @Override
    public Integer[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String rolId = resultSet.getString(i);
        rolId = rolId.substring(1, rolId.length() - 1);
        if (rolId.length() == 1){
            Integer[] rolIdsList = new  Integer[1];
            rolIdsList[0] = Integer.parseInt(rolId);
            return rolIdsList;
        } else {
            String[] rolIdsStringList = rolId.split(",");
            Integer[] rolIdsList = new  Integer[rolIdsStringList.length];
            for (int j = 0; j < rolIdsStringList.length; j++) {
                rolIdsList[j] = Integer.parseInt(rolIdsStringList[j]);
            }
            return rolIdsList;
        }
    }

    @Override
    public Integer[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String rolId = callableStatement.getString(i);
        rolId = rolId.substring(1, rolId.length() - 1);
        if (rolId.length() == 1){
            Integer[] rolIdsList = new  Integer[1];
            rolIdsList[0] = Integer.parseInt(rolId);
            return rolIdsList;
        } else {
            String[] rolIdsStringList = rolId.split(",");
            Integer[] rolIdsList = new  Integer[rolIdsStringList.length];
            for (int k = 0; k < rolIdsStringList.length; k++) {
                rolIdsList[k] = Integer.parseInt(rolIdsStringList[k]);
            }
            return rolIdsList;
        }
    }


}
