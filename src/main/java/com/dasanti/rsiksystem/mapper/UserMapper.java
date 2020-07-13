package com.dasanti.rsiksystem.mapper;

import com.dasanti.rsiksystem.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User getLogin(User user);

    User getUserInfo(String userName);
}
