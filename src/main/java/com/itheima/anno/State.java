package com.itheima.anno;

import com.itheima.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented //元注解 可以抽取到帮助文档里
//元注解 用在哪些地方 这里改成成属性上
@Target(ElementType.FIELD)
//元注解 什么时间段需要
@Retention(RetentionPolicy.RUNTIME)
//校验规则
@Constraint(validatedBy = {StateValidation.class})


public @interface State {
    //提供校验失败后的提示信息
    String message() default "state参数的值只能是已发布或草稿";
    //指定分组
    Class<?>[] groups() default {};
    //负载获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};

}
