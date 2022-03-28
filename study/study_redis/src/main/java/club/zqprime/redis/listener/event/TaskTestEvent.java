package club.zqprime.redis.listener.event;

import org.springframework.context.ApplicationEvent;

public class TaskTestEvent extends ApplicationEvent {

    public TaskTestEvent(Object source) {
        super(source);
    }
}
