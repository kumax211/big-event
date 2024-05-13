package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    @Select("select * from user where username =#{username}")
    User findByUserName(String username);

    @Insert("insert into user ( username, password, create_time, update_time) " +
            "values (#{username},#{password},now(),now())")
    void add(String username, String password);
}
