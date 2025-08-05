package com.zhc.service;


import com.zhc.entity.User;

public interface UserService {

    User findByUsername(String username);

    void insert(User user);
}
