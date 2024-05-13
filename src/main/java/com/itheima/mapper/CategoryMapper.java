package com.itheima.mapper;

import com.itheima.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    /**
     * 加
     *
     * @param category 类别
     * @param
     */
    @Insert("insert into category (category_name, category_alias,create_user,create_time,update_time) " +
            "values (#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);

    @Select("select * from category WHERE create_user =#{id}")
    List<Category> list(Integer id);

    @Select("select * from category where id =#{id}")
    Category byDetail(Integer id);


    @Update("update category set category_name =#{categoryName}," +
            "category_alias= #{categoryAlias}," +
            "update_time =#{updateTime} " +
            "where id =#{id};")
    void update(Category category);
    @Delete("delete from category where id =#{id};")
    void delete(Integer id);
}
