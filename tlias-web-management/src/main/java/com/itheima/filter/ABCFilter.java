package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author:deconglin
 * @date:2023-08-08-17:00
 * @description:
 */

//@WebFilter(urlPatterns = "/*")
public class ABCFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("ABC拦截到了求解");

        System.out.println("ABC放行之前的逻辑");
        //放行
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("ABC放行截之后的逻辑");
    }
}
