package com.itheima.service.serviceImpl;

import com.itheima.mapper.CategoryMapper;
import com.itheima.pojo.Category;
import com.itheima.service.CategoryService;
import com.itheima.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @projectName: big-event
 * @package: com.itheima.service.serviceImpl
 * @className: CategoryServiceImpl
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/13 20:31
 * @version: 1.0
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @Override
    public void add(Category category) {
        //创建时间
        category.setCreateTime(LocalDateTime.now());
        category.setUpdateTime(LocalDateTime.now());
        //获取id
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id= (Integer) map.get("id");
        category.setId(id);
        categoryMapper.add(category);




    }
}
