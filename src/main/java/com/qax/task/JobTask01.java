package com.qax.task;

import com.qax.mapper.UserMapper;
import com.qax.model.User;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author Guoqing.Qin
 * @ClassName JobTask01
 * @create 2021-01-04 17:38
 * @Description:定时任务
 */
@Slf4j
@Component
@SuppressWarnings("ALL")
public class JobTask01 {
    public JobTask01() {
        super();
    }

    //区分服务
    @Value("${server.port}")
    private String port;

    @Autowired
    private UserMapper userMapper;

    int i = 0;

    @Scheduled(cron = "* * * * * ?")
    /**
     * lockAtLeastForString的作用是为了防止在任务开始之初由于各个服务器同名任务的服务器时间差，启动时间差等这些造成的一些问题，有了这个时间设置后，
     *     就可以避免因为上面这些小的时间差造成的一些意外，保证一个线程在抢到锁后，即便很快执行完，也不要立即释放，留下一个缓冲时间。
     *     这样等多个线程都启动后，由于任务已经被锁定，其他没有获得锁的任务也不会再去抢锁。注意这里的时间不要设置几秒几分钟，尽量大些
     *lockAtMostForString 这个设置的作用是为了防止抢到锁的那个线程，因为一些意外死掉了，而锁又始终不被释放。
     *     这样的话，虽然当前执行周期虽然失败了，但以后的执行周期如果这里一直不释放的话，后面就永远执行不到了。
     *     它的目的不在于隐藏任务，更重要的是，释放锁，并且查找解决问题。
     *至于是否带有string后缀，只是2种表达方式，数字类型的就是毫秒数，字符串类型的就有自己固定的格式 ，例如：PT30S  30s时间设置，单位可以是S,M,H
     *
     * lockAtLeastForString：最小持有锁的时间，在持有锁期间，其他同名任务不能执行，最好和任务的时间差不多
     *  1、当执行任务时间 < lockAtLeastForString时：锁时间=获取到锁时间+lockAtLeastForString时
     *  2、当执行任务时间 > lockAtLeastForString时:锁时间=获取到锁时间+行任务时间
     *  3、当执行任务时间 > lockAtMostForString:一般将lockAtMostForString设置大一点
     * lockAtMostForString：最长持有锁时间，时间到了自动释放锁，当任务异常或死亡，会在设定时间后自动释放锁，这个可以不设置，因为已经有了默认值，尽量设置大一点
     */
    @SchedulerLock(name = "scheduledController_notice", lockAtLeastForString = "PT2S", lockAtMostForString = "PT50S")
    public String notice() {

        try {
            log.info(port + "- 执行定时器 scheduledController_notice+{}", i++);
            Integer maxNum = userMapper.selectUserMaxNum();
            Integer num = Optional.ofNullable(maxNum).orElse(0);
            User user = new User(null, "zs", num + 1);
            userMapper.insert(user);
            log.info("zs user ={}", user);

            return "Success!!";
        } catch (Exception e) {
            log.error("异常信息:", e);
            return "faild";
        }
    }

}
