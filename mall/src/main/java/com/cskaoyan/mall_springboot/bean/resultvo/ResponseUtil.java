package com.cskaoyan.mall_springboot.bean.resultvo;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther 芮狼Dan
 * @date 2019-05-23 21:44
 *
 * 返回值
 */
public class ResponseUtil {
    //成功的封装信息无参
    public static Object ok() {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        return obj;
    }

    //成功的封装信息
    public static Object ok(Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", 0);
        obj.put("errmsg", "成功");
        obj.put("data",data);
        return obj;
    }


    //失败的信息封装
    public static Object fail(int errno, String errmsg) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("errno", errno);
        obj.put("errmsg", errmsg);
        return obj;
    }


    //失败401
    public static Object badArgument(){
        return fail(401,"参数不对");
    }



}
