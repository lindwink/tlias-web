package com.itheima.config;

import com.itheima.interceptor.loginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author:deconglin
 * @date:2023-08-08-20:36
 * @description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private loginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/login");;
    }
}
