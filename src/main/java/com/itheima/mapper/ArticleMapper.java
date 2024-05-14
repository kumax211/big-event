package com.itheima.mapper;

import com.itheima.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @projectName: big-event
 * @package: com.itheima.mapper
 * @className: ArticleMapper
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/14 10:40
 * @version: 1.0
 */

@Mapper
public interface ArticleMapper {
    @Insert("insert into article (title, content, cover_img, state, category_id, create_user, create_time, update_time) " +
            "values (#{title},#{content},#{coverImg},#{state},#{categoryId},#{createUser},now(),now());")
    void add(Article article);

    List<Article> list(Integer integer, String state, Integer categoryId);
}
