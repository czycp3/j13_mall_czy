package com.cskaoyan.mall_springboot.controller;

import com.cskaoyan.mall_springboot.bean.Admin;
import com.cskaoyan.mall_springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther 芮狼Dan
 * @date 2019-05-22 16:59
 * 登陆Controller
 */
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;






    @RequestMapping("/auth/login")
    @ResponseBody
    public Map<String,Object> login(@RequestBody HashMap data){
        Map<String,Object> map = new HashMap<>();
        String username = (String)data.get("username");
        String password= (String)data.get("password");
//        int i = loginService.selectAdminByUnameAndPsw(username,password);

//        if (i == 1){
//            map.put("errno",605);
//
//
//        }else{
//            map.put("errno",605);
//            map.put("errmsg","用户帐号或密码不正确");
//        }
        map.put("errno",0);
       // map.put("data","dsafhjkdrrhjraklsd");
        map.put("errmsg","成功");
//



        return map;
    }

    @RequestMapping("/auth/info")
    @ResponseBody
    public Map<String,Object> info(){
        Map<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();

        map2.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        map2.put("name","admin123");
        List perms = new ArrayList();
        perms.add("*");
        List roles = new ArrayList();
        roles.add("超级管理员");
        map2.put("perms",perms);
        map2.put("roles",roles);
        map1.put("data",map2);
        map1.put("errmsg","成功");
        map1.put("errno",0);
        return map1;
    }
}
