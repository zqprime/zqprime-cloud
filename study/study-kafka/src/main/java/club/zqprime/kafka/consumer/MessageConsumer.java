package club.zqprime.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

//    @KafkaListener(topics = "hello", groupId = "defaultGroup")
//    public void hello(ConsumerRecord<?, ?> record){
//        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
//    }

    /**
     * 手动确认消息
     * @param record
     * @param ack
     */
    @KafkaListener(topics = "hello", groupId = "defaultGroup")
    public void hello(ConsumerRecord<?, ?> record, Acknowledgment ack){
        System.out.println("简单消费："+record.topic()+"-"+record.partition()+"-"+record.value());
        ack.acknowledge();
    }

//    /**
//     * 配置多个消费组
//     * @param record
//     */
//    @KafkaListener(topics = "hello", groupId = "defaultGroup2")
//    public void hello2(ConsumerRecord<?, ?> record){
//        System.out.println("简单消费2："+record.topic()+"-"+record.partition()+"-"+record.value());
//    }

    @KafkaListener(topics = "user", groupId = "defaultGroup")
    public void user(ConsumerRecord<?, ?> record, Acknowledgment ack){
        System.out.println("简单消费USER："+record.topic()+"-"+record.partition()+"-"+record.value());
        ack.acknowledge();
    }
}