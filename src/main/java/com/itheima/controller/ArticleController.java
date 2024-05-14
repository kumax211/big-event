package com.itheima.controller;

import com.itheima.pojo.Article;
import com.itheima.pojo.Result;
import com.itheima.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.management.MBeanServer;

/**
 * @projectName: big-event
 * @package: com.itheima.controller
 * @className: ArticleController
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/13 12:07
 * @version: 1.0
 */
@RestController
@RequestMapping("/article")

public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Result add(@RequestBody  @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }

}
