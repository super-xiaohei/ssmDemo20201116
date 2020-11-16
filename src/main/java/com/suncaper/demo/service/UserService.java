package com.suncaper.demo.service;

import com.suncaper.demo.entity.User;

import java.util.List;

/**
 * @author zyq
 * @date 2020/11/10 - 11:27
 */
public interface UserService {

    List<User> selectAll();

    User selectById(Integer id);

    User selectByUser(User user);

    boolean insert(User user);
}
