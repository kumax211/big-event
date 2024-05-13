package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.pojo.User;
import com.itheima.serviec.Userservice;
import com.itheima.utils.JwtUtil;
import com.itheima.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
@Slf4j
@Validated
public class UserController {


    @Autowired
    private Userservice userservice;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username,
                           @Pattern(regexp = "^\\S{5,16}$") String password) {        //查询用户-是否被占用
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

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username,
                                @Pattern(regexp = "^\\S{5,16}$") String password) {
        //获得id
        User loginUser = userservice.findByUserName(username);
        //判断user 是否存在

        if (loginUser == null) {
            //用户不存在
            return Result.error("用户名不正确");
        }else {
            //用户存在=>
            //判断password是否正确
            //加密操作
            String md5String = Md5Util.getMD5String(password);
            if (md5String.equals(loginUser.getPassword())){
                HashMap<String, Object> claims = new HashMap<>();
                claims.put("id",loginUser.getId());
                claims.put("username",loginUser.getUsername());
                String token = JwtUtil.genToken(claims);
                //密码正确,登陆成功
                return Result.success(token);
            }
            //密码错误
            return Result.error("密码错误");



        }
    }



}
