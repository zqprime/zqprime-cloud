package club.zqprime.myspring.config;

import club.zqprime.myspring.interceptor.TestInterceptor;
import org.apache.logging.log4j.spi.LoggerRegistry;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zqprime
 * @description
 * @date 2023/6/25 8:47
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor())
                .addPathPatterns("/testController/getUUID")
                .addPathPatterns("/testController/getUUID2");
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public TestInterceptor testInterceptor(){
        return new TestInterceptor();
    }
}
