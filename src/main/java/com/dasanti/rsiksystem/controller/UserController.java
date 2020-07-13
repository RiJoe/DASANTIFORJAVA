package com.dasanti.rsiksystem.controller;

import com.dasanti.rsiksystem.entity.User;
import com.dasanti.rsiksystem.service.UserService;
import com.dasanti.rsiksystem.util.ResultEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/get/login")
    public ResultEntity<User> getUser(@RequestBody User userInfo){

        try{
            String userName = userInfo.getUserName();
            String password = userInfo.getPassword();
            User user = userService.getUserInfo(userName);
            if (user == null){
                return ResultEntity.failed("用户不存在");
            }else{
                if (!user.getPassword().equals(password)){
                    return ResultEntity.failed("密码错误");
                }
            }

            return ResultEntity.successWithData(user);
        }catch (Exception e){
            e.printStackTrace();
            return ResultEntity.failed(e.getMessage());
        }
    }


}
