package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @projectName: big-event
 * @package: com.itheima.mapper
 * @className: UserMapper
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/13 10:25
 * @version: 1.0
 */

@Mapper
public interface UserMapper {

    /**
     * 按用户名查找
     *
     * @param username 用户名
     * @return {@link User}
     */
    @Select("select * from user where username =#{username}")
    User findByUserName(String username);

    /**
     * 加
     *
     * @param username 用户名
     * @param password 密码
     */
    @Insert("insert into user ( username, password, create_time, update_time) " +
            "values (#{username},#{password},now(),now())")
    void add(String username, String password);

    /**
     * 更新
     *
     * @param user 用户
     */
    @Update("update user set nickname = #{nickname},email =#{email},update_time = #{updateTime} " +
            "where id = #{id}")
    void update(User user);

    /**
     * 更新头像
     *
     * @param avatarUrl 头像网址
     * @param id
     */
    @Update("update user set user_pic = #{avatarUrl},update_time =now() where id =#{id}")
    void updateAvatar(String avatarUrl, Integer id);

    /**
     * 更新 PWD
     *
     * @param newPwd 新PWD
     * @param id 同上
     */
    @Update("update user set password = #{newPwd},update_time=now() where id=#{id}")
    void updatePwd(String newPwd, Integer id);
}
