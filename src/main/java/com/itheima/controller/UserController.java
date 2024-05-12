package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.serviec.Userservice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {


    @Autowired
    private Userservice userservice;

    @PostMapping("/register")
    public Result<String> register(String username, String password) {
        //查询用户-是否被占用
        User user = userservice.findByUserName(username);
        if (user == null) {
            //没有被占用
            //注册
            userservice.register(username, password);
            return Result.success();

        } else {
            //被占用了
            return Result.error("用户名已被占用");

        }


    }


}
