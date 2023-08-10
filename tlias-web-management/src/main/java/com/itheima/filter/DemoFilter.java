package com.itheima.filter;

import org.springframework.boot.web.servlet.ServletComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author:deconglin
 * @date:2023-08-08-16:37
 * @description:
 */

//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    @Override //初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init方法执行了");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("demo拦截到了求解");

        System.out.println("demo放行之前的逻辑");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("demo放行截之后的逻辑");
    }

    @Override //销毁1次
    public void destroy() {
        System.out.println("destroy方法执行了");
    }
}
