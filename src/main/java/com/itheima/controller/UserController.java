package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: big-event
 * @package: com.itheima.controller
 * @className: UserController
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/13 10:24
 * @version: 1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(String username,String password){
        User user =userService.findByUserName(username);
       if (user==null){
           userService.register(username,password);
           return Result.success();
       }else {
           return Result.error("用户已注册");
       }
    }
}
