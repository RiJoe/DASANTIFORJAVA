package com.dasanti.rsiksystem.service;

import com.dasanti.rsiksystem.entity.User;

public interface UserService {
    User getLogin(User user);

    User getUserInfo(String userName);
}
