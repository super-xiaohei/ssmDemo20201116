package com.suncaper.demo.service.impl;

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.suncaper.demo.entity.User;
import com.suncaper.demo.mapper.UserMapper;
import com.suncaper.demo.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyq
 * @date 2020/11/10 - 11:27
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> selectAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(1);
    }

    @Override
    public User selectByUser(User user) {
        return userMapper.selectByUser(user);
    }

    @Override
    public boolean insert(User user) {
        return userMapper.insert(user) != 0;
    }

}
