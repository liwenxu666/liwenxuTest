package com.lwx.service.impl;

import com.lwx.mapper.UserMapper;
import com.lwx.pojo.User;
import com.lwx.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);

    }
}
