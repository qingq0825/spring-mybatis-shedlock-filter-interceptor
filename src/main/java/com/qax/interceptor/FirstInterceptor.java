package com.qax.interceptor;

import com.qax.model.User;
import com.qax.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author Guoqing.Qin
 * @ClassName FirstInterceptor
 * @create 2021-01-06 13:40
 * @Description:
 */
@Slf4j
@SuppressWarnings("ALL")
public class FirstInterceptor implements HandlerInterceptor {
    public FirstInterceptor() {
        super();
    }

    @Autowired
    private UserService userService;

    /**
     * 当返回true时才会放行，走到controller
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("进入 FirstInterceptor.preHandle ....");
        User user = userService.selectByPrimaryKey(581);
        User defaultUser = Optional.ofNullable(user).orElse(new User());
        log.info("退出 FirstInterceptor.preHandle ...... defaultUser = {}", defaultUser.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("进入 FirstInterceptor.postHandle ####");

        log.info("退出 FirstInterceptor.postHandle ####");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        log.info("进入 FirstInterceptor.afterCompletion ####");

    }
}
