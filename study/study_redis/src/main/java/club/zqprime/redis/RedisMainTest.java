package club.zqprime.redis;

import club.zqprime.redis.listener.event.TaskTestEvent;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisMain.class})
public class RedisMainTest {
    @Resource
    private ApplicationEventPublisher publisher;

    @Test
    public void testTask(){
        TaskTestEvent testEvent = new TaskTestEvent("hahaha");
        publisher.publishEvent(testEvent);
    }

}
