package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @projectName: big-event
 * @package: com.itheima.exception
 * @className: GlobalExceptionHandler
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/13 11:23
 * @version: 1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage())? e.getMessage() : "操作失败");
    }

}
