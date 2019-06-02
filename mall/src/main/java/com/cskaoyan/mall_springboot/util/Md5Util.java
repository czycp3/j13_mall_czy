package com.cskaoyan.mall_springboot.util;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Util {
    /**
     * MD5方法
     *
     * @param text 明文
     * @param key 盐
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {
        //加密后的字符串
        String encodeStr= DigestUtils.md5Hex(text + key);
        System.out.println("MD5加密后的字符串为:encodeStr="+encodeStr);
        return encodeStr;
    }

}
