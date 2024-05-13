package com.itheima.service;

import com.itheima.pojo.User;

/**
 * @projectName: big-event
 * @package: com.itheima.service
 * @className: UserService
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/13 10:26
 * @version: 1.0
 */


public interface UserService {
    User findByUserName(String username);

    void register(String username, String password);
}
