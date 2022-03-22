package club.zqprime.kafka.controller;

import club.zqprime.kafka.model.Study;
import club.zqprime.kafka.producer.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/kafka")
public class MessageController {

    @Resource
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
