package club.zqprime.kafka.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class SomeTopicReceiver {

    @KafkaListener(topics = "someTopic")
    public void processMessage(String content) {
        log.info("收到someTopic消息：{}",content);
    }
}