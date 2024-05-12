package com.itheima.serviec.serviceImpl;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.serviec.Userservice;
import com.itheima.utils.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements Userservice {
    @Autowired
    private UserMapper userMapper;

    //根据用户名查询用户
    @Override
    public User findByUserName(String username) {

        User user = userMapper.findByUserName(username);

        return user;
    }

    //注册用户
    @Override
    public void register(String username, String password) {
        //密码要做加密处理
        String md5String = Md5Util.getMD5String(password);
        userMapper.add(username,md5String);


    }
}
