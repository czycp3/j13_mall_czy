package com.cskaoyan.mall_springboot.util;

import java.util.UUID;

/**
 * @author CZY-Y7000P
 */
public class UuidGenerator {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }
}
