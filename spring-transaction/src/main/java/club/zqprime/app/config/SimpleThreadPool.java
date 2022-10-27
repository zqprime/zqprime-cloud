package club.zqprime.app.config;

import cn.hutool.core.thread.RejectPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zqprime
 * @date 2022/8/25 16:57
 */
@Component
public class SimpleThreadPool {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(){
        return new ThreadPoolExecutor(5,50,30,
                TimeUnit.MINUTES,new ArrayBlockingQueue<>(2000),
                Executors.defaultThreadFactory(), RejectPolicy.CALLER_RUNS.getValue());
    }
}