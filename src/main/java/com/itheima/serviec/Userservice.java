package com.itheima.serviec;

import com.itheima.pojo.User;

public interface Userservice {

    //根据用户名查询用户
    User findByUserName(String username);
    //注册用户
    void register(String username, String password);
}
