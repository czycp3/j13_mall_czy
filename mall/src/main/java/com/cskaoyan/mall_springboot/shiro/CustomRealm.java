package com.cskaoyan.mall_springboot.shiro;

import com.cskaoyan.mall_springboot.bean.Admin;
import com.cskaoyan.mall_springboot.service.LoginService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @auther 芮狼Dan
 * @date 2019-05-24 09:58
 */
@Component
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    LoginService loginService;

    //处理授权信息
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection){
        if (principalCollection == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        Admin admin = (Admin) getAvailablePrincipal(principalCollection);
        Integer[] roleIds = admin.getRoleIds();
        Set<String> roles = loginService.quaryByIds(roleIds);
        Set<String> permissions = loginService.quaryByRoleIds(roleIds);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles);
        info.setStringPermissions(permissions);

        return info;
    }


    //处理认证信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();
        String password = new String(upToken.getPassword());

        if (username == null || username.equals("")){
            return (AuthenticationInfo) new AccountException("用户名不能为空");
        }
        if (password == null || password.equals("")){
            return (AuthenticationInfo) new AccountException("密码不能为空");
        }

        List<Admin> adminList = loginService.findAdminByUsername(username);




        Admin admin = adminList.get(0);
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(admin,admin.getPassword(),getName());



        return simpleAuthenticationInfo;
    }
}

