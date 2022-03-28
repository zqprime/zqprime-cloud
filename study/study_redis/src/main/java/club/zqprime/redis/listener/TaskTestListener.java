package club.zqprime.redis.listener;

import club.zqprime.redis.listener.event.TaskTestEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
public class TaskTestListener implements ApplicationListener<TaskTestEvent> {

    Map<String, Function<String,Object>> map;
    @PostConstruct
    public void init(){
        map  = new HashMap<>();
        map.put("haha",this::haha);
    }

    @Override
    @Async("taskExecutor")
    public void onApplicationEvent(TaskTestEvent event) {
        Object haha = testHaha();
    }


    public Object testHaha(){
        return map.get("haha").apply("haha");
//        return haha("haha");
    }

    public Object haha(String haha){
        System.out.println("=============");
        log.info(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
        return null;
    }
}
