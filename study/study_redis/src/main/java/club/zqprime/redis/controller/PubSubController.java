package club.zqprime.redis.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/pubsub")
public class PubSubController {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/test")
    public void testList(@RequestParam String data){
        redisTemplate.convertAndSend("haha",data);
    }
}
