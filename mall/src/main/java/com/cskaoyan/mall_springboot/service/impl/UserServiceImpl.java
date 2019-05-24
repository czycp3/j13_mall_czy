package com.cskaoyan.mall_springboot.service.impl;

import com.cskaoyan.mall_springboot.bean.PageHelper;
import com.cskaoyan.mall_springboot.bean.user.*;
import com.cskaoyan.mall_springboot.bean.resultvo.BaseQueryVo;
import com.cskaoyan.mall_springboot.bean.resultvo.ResultVo;
import com.cskaoyan.mall_springboot.mapper.UserMapper;
import com.cskaoyan.mall_springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cly
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public BaseQueryVo queryUserList(PageHelper pageHelper,User user) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<User> resultVo = new ResultVo<>();

        //获取总条目数
        int total = userMapper.selectCounAlltUser(user);
        resultVo.setTotal(total);
        //获取记录
        List<User> items = userMapper.selectAllUser(pageHelper,user);
        resultVo.setItems(items);
        baseQueryVo.setData(resultVo);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");
        return baseQueryVo;
    }

    @Override
    public BaseQueryVo queryFeedBackList(PageHelper pageHelper, FeedBack feedBack) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<FeedBack> resultVo = new ResultVo<>();

        //获取总条目数
        int total = userMapper.selectCountAllFeedBack(feedBack);
        resultVo.setTotal(total);
        //获取记录
        List<FeedBack> items = userMapper.selectAllFeedBack(pageHelper,feedBack);
        resultVo.setItems(items);
        baseQueryVo.setData(resultVo);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");
        return baseQueryVo;
    }

    @Override
    public BaseQueryVo queryHistoryList(PageHelper pageHelper, History history) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<History> resultVo = new ResultVo<>();

        //获取总条目数
        int total = userMapper.selectCountAllHistory(history);
        resultVo.setTotal(total);
        //获取记录
        List<History> items = userMapper.selectAllHistory(pageHelper, history);
        resultVo.setItems(items);
        baseQueryVo.setData(resultVo);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");
        return baseQueryVo;
    }

    @Override
    public BaseQueryVo queryFootPrintList(PageHelper pageHelper, FootPrint footPrint) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<FootPrint> resultVo = new ResultVo<>();

        //获取总条目数
        int total = userMapper.selectCountAllFootPrint(footPrint);
        resultVo.setTotal(total);
        //获取记录
        List<FootPrint> items = userMapper.selectAllFootPrint(pageHelper, footPrint);
        resultVo.setItems(items);
        baseQueryVo.setData(resultVo);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");
        return baseQueryVo;
    }

    @Override
    public BaseQueryVo queryCollectList(PageHelper pageHelper, Collect collect) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<Collect> resultVo = new ResultVo<>();

        //获取总条目数
        int total = userMapper.selectCountAllCollect(collect);
        resultVo.setTotal(total);
        //获取记录
        List<Collect> items = userMapper.selectAllCollect(pageHelper, collect);
        resultVo.setItems(items);
        baseQueryVo.setData(resultVo);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");
        return baseQueryVo;
    }

    @Override
    public BaseQueryVo queryAddressList(PageHelper pageHelper, Address address) {
        BaseQueryVo baseQueryVo = new BaseQueryVo();
        ResultVo<Address> resultVo = new ResultVo<>();

        //获取总条目数
        int total = userMapper.selectCountAllAddress(address);
        resultVo.setTotal(total);
        //获取记录
        List<Address> items = userMapper.selectAllAddress(pageHelper, address);
        resultVo.setItems(items);
        baseQueryVo.setData(resultVo);
        baseQueryVo.setErrno(0);
        baseQueryVo.setErrmsg("成功");
        return baseQueryVo;
    }
}
