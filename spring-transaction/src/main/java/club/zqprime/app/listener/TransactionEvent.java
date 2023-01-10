package club.zqprime.app.listener;

import org.springframework.context.ApplicationEvent;

public class TransactionEvent extends ApplicationEvent {

    public TransactionEvent(Object source) {
        super(source);
    }
}
