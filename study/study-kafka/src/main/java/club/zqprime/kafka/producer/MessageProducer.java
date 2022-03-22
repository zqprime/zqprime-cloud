package club.zqprime.kafka.producer;

import club.zqprime.kafka.model.Study;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;

    /**
     * 发送消息
     * @param content
     */
    public void sendMessage(String content){
        kafkaTemplate.send("hello",content);
    }

    public void sendUserMessage(Study study){
        kafkaTemplate.send("user", JSON.toJSONString(study));
    }

}