package com.qax.config;

import com.qax.interceptor.FirstInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author Guoqing.Qin
 * @ClassName WebMvcConfigurer
 * @create 2021-01-06 13:45
 * @Description:注册拦截器
 */
@Configuration
@SuppressWarnings("ALL")
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {
    public WebMvcConfigurer() {
        super();
    }

    /**
     * 使用@Bean的方式交给Spring来管理，
     * 如果直接new FirstInterceptor()则会发现拦截器中无法使用Spring容器中的Bean
     *
     * @return
     */
    @Bean
    public FirstInterceptor buildFirstInterceptor() {
        return new FirstInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器情况下按照注册的顺序执行
        registry.addInterceptor(buildFirstInterceptor()).addPathPatterns("/user/index/*");
        super.addInterceptors(registry);
    }
}
