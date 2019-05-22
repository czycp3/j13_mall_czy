package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.User;
import com.cskaoyan.mall_springboot.mapper.UserMapper;
import com.cskaoyan.mall_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author CZY-Y7000P
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean login(User user) {
        User login = userMapper.login(user);
        return login != null;
    }
}
