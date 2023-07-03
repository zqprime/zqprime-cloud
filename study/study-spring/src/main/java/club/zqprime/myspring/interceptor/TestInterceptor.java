package club.zqprime.myspring.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zqprime
 * @description
 * @date 2023/6/25 8:45
 */
public class TestInterceptor implements HandlerInterceptor {

    public TestInterceptor(){
        System.out.println("TestInterceptor 构造器执行了");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("当前对象："+this);
        System.out.println("handler："+handler);
        System.out.println("preHandle 拦截器执行了");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("当前对象："+this);
        System.out.println("handler："+handler);
        System.out.println("postHandle 拦截器执行完成了");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("当前对象："+this);
        System.out.println("handler："+handler);
        System.out.println("执行了 afterCompletion");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
