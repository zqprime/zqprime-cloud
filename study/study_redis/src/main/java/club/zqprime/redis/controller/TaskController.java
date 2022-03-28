package club.zqprime.redis.controller;

import club.zqprime.redis.listener.event.TaskTestEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/task")
public class TaskController {
    @Resource
    private ApplicationEventPublisher publisher;

    @RequestMapping("/test")
//    @Async("taskExecutor")
    public void testTask(){
        TaskTestEvent testEvent = new TaskTestEvent("hahaha");
        publisher.publishEvent(testEvent);
    }
}
