package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.System;
import com.cskaoyan.mall_springboot.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @auther 芮狼Dan
 * @date 2019-05-22 23:01
 */
@Controller
public class ConfigController {
    @Autowired
    ConfigService configService;

    @RequestMapping(value = "/config/{config}" , method = RequestMethod.GET) //{config}
    @ResponseBody
    public Map<String,Object> search(@PathVariable("config")String config){ //,@RequestBody HashMap date
        Map<String,Object> map = new HashMap<>();
        Map<String,Object> listMap = new HashMap<>();

        String searchValue = "mall_"+ config;
        List<System> list = configService.searchByKeyName(searchValue);
        for (int i = 0; i < list.size() ; i++) {
            listMap.put(list.get(i).getKeyName(),list.get(i).getKeyValue());

        }

        map.put("errmsg","成功");
        map.put("errno",0);
        map.put("data",listMap);

        return  map;
    }

//    @RequestMapping(value = "/config/{config}" , method = RequestMethod.POST) //{config}
//    @ResponseBody
//    public String edit(@PathVariable("config")String config , @RequestBody String data){ //,@RequestBody HashMap date
//        data = data.substring(1, data.length() - 1);
//        String list[] = data.split(",");
//        for (int i = 0; i < list.length; i++){
//            String editItem[] = list[i].split(":");
//            String keyName = editItem[0].substring(1,editItem[0].length() - 1);
//            String keyValue = data[1].charAt(0) == 34 ? data[1].substring(1,data[1].length() - 1) : data[1];
//			System.out.println("key_value : " + keyValue);
//
//        }
//
//
//            return  null;
//    }

    @RequestMapping(value = "/config/{config}" , method = RequestMethod.POST) //{config}
    @ResponseBody
    public Map<String,Object> edit(@PathVariable("config")String config , @RequestBody HashMap<String,String> map){ //,@RequestBody HashMap date
        Map<String,Object> dataMap = new HashMap<>();
        for (Map.Entry<String,String> data :map.entrySet()){
            String keyName = data.getKey();
            String keyValue = data.getValue();
            configService.edit(keyName,keyValue);
        }

        dataMap.put("errmsg","成功");
        dataMap.put("errno",0);


        return  dataMap;
    }

}
