package com.itheima.controller;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.itheima.pojo.Category;
import com.itheima.pojo.Result;
import com.itheima.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: big-event
 * @package: com.itheima.controller
 * @className: CategoryController
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/13 20:28
 * @version: 1.0
 */

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

        @PostMapping
        public Result add(@RequestBody Category category) {
            categoryService.add(category);
            return Result.success();
        }

}
