package com.qax.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Guoqing.Qin
 * @ClassName TwoFilter
 * @create 2021-01-06 11:04
 * @Description:
 */

@Slf4j
//@Order(2)
//@WebFilter(filterName = "atwoFilter", urlPatterns = "/user/*")
@SuppressWarnings("ALL")
public class TwoFilter implements Filter {
    public TwoFilter() {
        super();
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("进入TwoFilter.init..... ");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("进入TwoFilter.doFilter..... ");
        // doFilter将请求转发给过滤器链下一个filter , 如果没有filter那就是你请求的资源
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("退出TwoFilter.doFilter.....");
    }

    @Override
    public void destroy() {
        log.info("进入TwoFilter.destroy..... ");
    }
}
