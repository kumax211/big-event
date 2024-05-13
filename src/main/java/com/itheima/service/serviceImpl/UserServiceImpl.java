package com.itheima.service.serviceImpl;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.Md5Util;
import com.itheima.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

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

    /**
     * 按用户名查找
     *
     * @param username 用户名
     * @return {@link User}
     */
    @Override
    public User findByUserName(String username) {

        return userMapper.findByUserName(username);
    }

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     */
    @Override
    public void register(String username, String password) {
        //  md5加密
        String md5String = Md5Util.getMD5String(password);
        userMapper.add(username, md5String);
    }

    /**
     * 更新
     *
     * @param user 用户
     */
    @Override
    public void update(User user) {
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);

    }

    /**
     * 更新头像
     *
     * @param avatarUrl 头像网址
     *///
    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }

    /**
     * 更新 PWD
     *
     * @param md5String md5 字符串
     */
    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(newPwd,id);
    }


}
