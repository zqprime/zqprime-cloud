package club.zqprime.kafka.controller;

import club.zqprime.kafka.privoder.KafkaPrivoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/kafka")
public class MessageController {

    @Resource
    private KafkaPrivoder kafkaPrivoder;

    @GetMapping(value = "/send/{topic}/{data}")
    public Object send(@PathVariable(value = "topic") String topic,@PathVariable(value = "data") String data){
        kafkaPrivoder.sendMessage(topic,data);
        return "SUCCESS";
    }
}
