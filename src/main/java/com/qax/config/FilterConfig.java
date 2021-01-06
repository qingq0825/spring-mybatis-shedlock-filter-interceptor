package com.qax.config;

import com.qax.filter.FirstFilter;
import com.qax.filter.TwoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author Guoqing.Qin
 * @ClassName FilterConfig
 * @create 2021-01-06 11:23
 * @Description:配置过滤器执行顺序
 */
//@Configuration
@SuppressWarnings("ALL")
public class FilterConfig {
    public FilterConfig() {
        super();
    }

    @Bean
    public FilterRegistrationBean buildFirstFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setOrder(2); // 决定执行doFilter的顺序
        filterRegistrationBean.setFilter(new FirstFilter());
        filterRegistrationBean.setName("bfirstFilter"); // filterName决定 init的顺序
        filterRegistrationBean.addUrlPatterns("/user/*");
//        filterRegistrationBean.setInitParameters(); // 设置初始化参数
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean buildTwoFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setOrder(1);
        filterRegistrationBean.setFilter(new TwoFilter());
        filterRegistrationBean.setName("atwoFilter");
        filterRegistrationBean.addUrlPatterns("/user/*");
        return filterRegistrationBean;
    }
}
