package com.dasanti.rsiksystem.service.serviceImpl;

import com.dasanti.rsiksystem.entity.User;
import com.dasanti.rsiksystem.mapper.UserMapper;
import com.dasanti.rsiksystem.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User getLogin(User user) {
        return userMapper.getLogin(user);
    }

    @Override
    public User getUserInfo(String userName) {
        return userMapper.getUserInfo(userName);
    }
}
