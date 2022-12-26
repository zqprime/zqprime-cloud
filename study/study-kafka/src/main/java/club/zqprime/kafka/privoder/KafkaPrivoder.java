package club.zqprime.kafka.privoder;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaPrivoder {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaPrivoder(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic,String data){
        kafkaTemplate.send(topic,data);
    }
}