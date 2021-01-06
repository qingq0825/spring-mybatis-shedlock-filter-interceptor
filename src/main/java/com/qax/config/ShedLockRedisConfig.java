package com.qax.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Guoqing.Qin
 * @ClassName ShedLockRedisConfig
 * @create 2021-01-04 17:35
 * @Description:
 */
@EnableSchedulerLock(defaultLockAtMostFor = "PT5S")
@Configuration
@SuppressWarnings("ALL")
public class ShedLockRedisConfig {
    public ShedLockRedisConfig() {
        super();
    }

    @Bean
    public LockProvider lockProvider(RedisTemplate redisTemplate) {
        return new RedisLockProvider(redisTemplate.getConnectionFactory());
    }
}
