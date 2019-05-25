package com.cskaoyan.mall_springboot.controller;

//import com.cskaoyan.mall_springboot.bean.Admin;
//import com.cskaoyan.mall_springboot.service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;

import com.cskaoyan.mall_springboot.bean.Admin;
import com.cskaoyan.mall_springboot.bean.resultvo.ResponseUtil;
import com.cskaoyan.mall_springboot.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @auther 芮狼Dan
 * @date 2019-05-22 16:59
 * 登陆Controller
 */
@Controller
@Validated
public class LoginController {
    @Autowired
    LoginService loginService;






    @RequestMapping("/auth/login")
    @ResponseBody
    public Object login(@RequestBody HashMap data, HttpServletRequest request){
        //获取用户名和密码
        String username = (String)data.get("username");
        String password= (String)data.get("password");

        if (username.equals("") || username == null || password.equals("") || password == null){
            return ResponseUtil.badArgument();
        }

        Subject currentUser = SecurityUtils.getSubject();

        try {
            currentUser.login(new UsernamePasswordToken(username,password));
        } catch (UnknownAccountException uae) {
            return ResponseUtil.fail(605,"账号或密码错");
        } catch (LockedAccountException lae){
            return ResponseUtil.fail(605,"用户帐号已锁定不可用");
        } catch (AuthenticationException ae){
            return ResponseUtil.fail(605,"认证失败");
        }

        currentUser = SecurityUtils.getSubject();

        Admin admin = (Admin) currentUser.getPrincipal();
        admin.setLastLoginTime(new Date());
        loginService.upDateById(admin);

        //info
        Map<String,Object> adminInfo = new HashMap<>();
        adminInfo.put("nickName",admin.getUsername());
        adminInfo.put("avatar",admin.getAvatar());

        Map<String,Object> result = new HashMap<>();
        result.put("token",currentUser.getSession().getId());
        result.put("adminInfo",adminInfo);

        return ResponseUtil.ok(result);

    }



    //@RequiresAuthentication
    @PostMapping("/auth/logout")
    public Object logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return ResponseUtil.ok();
    }


    @RequestMapping("/auth/info")
    @ResponseBody
    public Object info(){
//        Subject subject = SecurityUtils.getSubject();
//        Admin admin = (Admin) subject.getPrincipal();
//        Map<String, Object> data = new HashMap<>();
//        data.put("name", admin.getUsername());
//        data.put("avatar", admin.getAvatar());
////
//        Integer[] roleIds = admin.getRoleIds();
//        Set<String> roles = loginService.quaryByIds(roleIds);
//        Set<String> permissions = loginService.quaryByRoleIds(roleIds);
//
//        data.put("roles", roles);
//        data.put("perms", permissions);
//
//        return ResponseUtil.ok(data);






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
