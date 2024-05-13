package com.itheima.service.serviceImpl;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @projectName: big-event
 * @package: com.itheima.service.serviceImpl
 * @className: UserServiceImpl
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/13 10:27
 * @version: 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String username) {

        return userMapper.findByUserName(username);
    }

    @Override
    public void register(String username, String password) {
    //  md5加密
        String md5String = Md5Util.getMD5String(password);
        userMapper.add(username,md5String);
    }
}
