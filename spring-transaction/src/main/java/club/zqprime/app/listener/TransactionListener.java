package club.zqprime.app.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

/**
 * @author zqprime
 * @date 2022/12/29 16:32
 */
@Slf4j
@Component
public class TransactionListener {

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT,classes = TransactionEvent.class)
    public void listener(TransactionEvent event){
        log.info("接收到事件：{}",event.getSource());
    }


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT,classes = TransactionEvent.class)
    public void listener2(TransactionEvent event){
        log.info("接收到事件2：{}",event.getSource());
    }
}
