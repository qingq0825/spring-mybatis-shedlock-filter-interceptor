package com.qax.filter;

import com.qax.model.User;
import com.qax.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author Guoqing.Qin
 * @ClassName FirstFilter
 * @create 2021-01-06 10:11
 * @Description: 第一个filter
 * @Order注解表示执行过滤顺序，值越小，越先执行 无效，和filterName有关
 */
@Slf4j
//@Order(1)
//@WebFilter(filterName = "bfirstFilter",
//        urlPatterns = {"/user/*"},
//        initParams = {@WebInitParam(name = "ok", value = "hello")})
@SuppressWarnings("ALL")
public class FirstFilter implements Filter {
    public FirstFilter() {
        super();
    }

    private String ok;

    @Autowired
    private UserService userService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 在启动servlet容器的时候初始化
        log.info("进入FirstFilter.init.....");
        ok = filterConfig.getInitParameter("ok");

        ServletContext context = filterConfig.getServletContext();
        WebApplicationContext cxt = WebApplicationContextUtils.getWebApplicationContext(context);
        userService = cxt.getBean(UserService.class);
        User user = userService.selectByPrimaryKey(581);
        log.info("退出FirstFilter.init..... user={}", user.toString());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("进入FirstFilter.doFilter..... ok={}", ok);
        // doFilter将请求转发给过滤器链下一个filter , 如果没有filter那就是你请求的资源
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("退出FirstFilter.doFilter.....");
    }

    @Override
    public void destroy() {
        // 停止servlet服务的时候进入该方法
        log.info("进入FirstFilter.destroy.....");
    }
}
