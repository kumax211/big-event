package com.itheima.config;

import com.itheima.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;
    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登陆接口,.excludePathPatterns 注册接口,不拦截
        registry.addInterceptor(loginInterceptor)
                .excludePathPatterns("/user/login","/user/register");
    }
}