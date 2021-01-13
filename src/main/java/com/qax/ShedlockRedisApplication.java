package com.qax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @EnableScheduling：开启定时任务
 * @ServletComponentScan：Servlet、Filter、Listener 可以直接通过 @WebServlet、@WebFilter、@WebListener 注解自动注册，无需其他代码
 */
@EnableScheduling
//@ServletComponentScan
@SpringBootApplication
public class ShedlockRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShedlockRedisApplication.class, args);
    }

}
