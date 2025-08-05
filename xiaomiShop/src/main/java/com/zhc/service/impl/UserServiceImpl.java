package com.zhc.service.impl;

import com.zhc.entity.User;
import com.zhc.mapper.UserMapper;
import com.zhc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);

    }

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }
}
