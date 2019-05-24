package com.cskaoyan.mall_springboot.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @Author: zero
 * @Date: 2019/5/23 15:20
 * @Version 1.0
 */
public class StringTypeHandlerUtils extends BaseTypeHandler<String[]> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        if(strings != null && strings.length != 0 ) {
            StringBuilder sb = new StringBuilder();
            for (String str : strings) {
                sb.append(str).append(",");
            }
            String substring = sb.toString().substring(sb.length() - 1);
            preparedStatement.setString(i, substring);
        }
    }

    /**
     * @Param resultSet 查询结果
     * @Param columnLabel 列名
     * @Return String[]  返回类型为String[]数组
     * @OtherMsg 查询结果为以逗号"[,]"形式分隔的String字符串,返回String[]数组
     */
    @Override
    public String[] getNullableResult(ResultSet resultSet, String columnLabel) throws SQLException {
//        String result= resultSet.getString(columnLabel);
//        String substring = result.substring(1, result.length() - 1);
//        if(substring!=null) {
//            String[] strings = substring.split(",");
//            for (int i = 0; i <strings.length; i++) {
//                strings[i] = strings[i].split("\"")[1];
//            }
//            return strings;
//        }
//        return new String[0];
        return resultSet.getString(columnLabel).split(",");
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return new String[0];
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return new String[0];
    }

}
