package club.zqprime;

import club.zqprime.kafka.StudyKafkaMain;
import club.zqprime.kafka.model.Study;
import club.zqprime.kafka.producer.MessageProducer;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.GetMapping;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudyKafkaMain.class})
public class KafkaTest {
    @Autowired
    private MessageProducer messageProducer;

    @GetMapping(value = "hello")
    public Object hello(String content){
        messageProducer.sendMessage(content);
        return "SUCCESS";
    }

    @GetMapping(value = "user")
    public Object user(Study study){
        messageProducer.sendUserMessage(study);
        return "SUCCESS";
    }
}
