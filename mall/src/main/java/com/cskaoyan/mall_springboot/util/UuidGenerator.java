package com.cskaoyan.mall_springboot.util;

import java.util.UUID;

public class UuidGenerator {
    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","").toLowerCase();
    }
}
