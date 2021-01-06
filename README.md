# 分布式任务锁ShedLock

- ShedLock是一个在分布式环境中使用的定时任务框架，用于解决在分布式环境中的多个实例的相同定时任务在同一时间点重复执行的问题。ShedLock确保计划的任务最多同时执行一次。如果一个任务正在一个节点上执行，它会获得一个锁，该锁将阻止从另一个节点（或线程）执行同一任务。请注意，如果一个任务已经在一个节点上执行，则在其他节点上的执行不会等待，只是将其跳过。。简单来说，ShedLock本身只做一件事情：保证一个任务最多同时执行一次。所以如官网所说的，ShedLock不是一个分布式调度器，只是一个锁!

https://blog.csdn.net/a767815662/article/details/104459814?utm_medium=distribute.pc_relevant.none-task-blog-searchFromBaidu-1.control&depth_1-utm_source=distribute.pc_relevant.none-task-blog-searchFromBaidu-1.control

# MyBatisCodeHelper插件的使用


# Springboot集成Servlet的Filter的两种方式

- 过滤器属于Servlet容器，在进入Dispatch之前执行，无法直接使用Spring中的Bean，可以使用ApplicationContext获取Bean
- 拦截器属于Spring容器，在进入Dispatch之后执行，Controller之前执行preHandle，Controller之后,retuen ModelAndView之前执行postHandle，并且可以使用Spring容器中的Bean

## 方式一：@ServletComponentScan+@WebFilter
- 在Filter上添加@WebFilter(filterName = "bfirstFilter",
                  urlPatterns = {"/user/*"},
                  initParams = {@WebInitParam(name = "ok", value = "hello")})
                  
- 在启动类上添加@ServletComponentScan

- Filter初始化顺序和filterName的名字字母顺序有关，无法设置doFilter的执行顺序，设置@Order无效

- 这种方式可以获取到Spring容器中的bean，但是无法指定顺序

## 方式二：使用配置的方式 @Configuration

- 新建自定义Filter
- 创建配置类
```java
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
```

## Spring的拦截器

### 创建拦截器
```java
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
```

### 配置拦截器

```java
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
```

在注册拦截器时使用@Bean的方式注册，在拦截器中才能使用Spring容器中的Bean，比如Service、Controller等
 使用@Bean的方式交给Spring来管理，
 如果直接new FirstInterceptor()则会发现拦截器中无法使用Spring容器中的Bean
 
# 拦截器和过滤器执行流程图

![](/src/main/resources/static/拦截器和过滤器执行流程.jfif)


