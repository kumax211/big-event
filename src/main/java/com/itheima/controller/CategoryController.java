package com.itheima.controller;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.itheima.pojo.Category;
import com.itheima.pojo.Result;
import com.itheima.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Result add(@RequestBody @Validated(Category.Add.class) Category category) {
        categoryService.add(category);
        return Result.success();
    }

    @GetMapping
    public Result<List<Category>> list() {
        List<Category> listCategory = categoryService.list();
        return Result.success(listCategory);
    }

    @GetMapping("/detail")
    public Result<Category> byDetail(Integer id) {
        Category category = categoryService.byDetail(id);
        return Result.success(category);
    }

    @PutMapping
    public Result update(@RequestBody @Validated(Category.Update.class) Category category) {
        categoryService.update(category);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(Integer id) {
        categoryService.delete(id);
        return Result.success();
    }

}
