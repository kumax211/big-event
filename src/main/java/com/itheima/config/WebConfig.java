package com.itheima.config;

import com.itheima.intercepts.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: big-event
 * @package: com.itheima.config
 * @className: WebConfig
 * @author: Eric
 * @description: TODO
 * @date: 2024/5/13 12:55
 * @version: 1.0
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登陆接口,注册接口,不拦截
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/user/login","/user/register");
    }
}
