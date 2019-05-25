package com.cskaoyan.mall_springboot.util;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: zero
 * @Date: 2019/5/24 21:59
 * @Version 1.0
 */
public class CrStringTypeHandlerUtils extends BaseTypeHandler<String[]> {


    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < strings.length; j++) {
            if(j==0){
                sb.append("[").append("\"").append(strings[j]).append("\"");
            }else if(j == strings.length - 1) {
                sb.append("\"").append(strings[j]).append("\"").append("]");
            }
            sb.append("\"").append(strings[j]).append("\"").append(",");
        }
        preparedStatement.setString(i, sb.toString());
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String columnLabel) throws SQLException {
        String result = resultSet.getString(columnLabel);
        String substring = result.substring(1, result.length() - 1);

        if (result != null && substring.length()!=0) {
            String[] strings = result.split(",");
            for (int i = 0; i < strings.length; i++) {
                strings[i] = strings[i].split("\"")[1];
            }
            return strings;
        }
        return new String[0];
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
