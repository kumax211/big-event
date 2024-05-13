package com.itheima.controller;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/list")
    public Result<String> list() {
        return Result.success("所有的文章数据");
    }

}
