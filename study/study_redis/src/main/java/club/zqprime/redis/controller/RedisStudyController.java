package club.zqprime.redis.controller;

import club.zqprime.redis.model.Study;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/study")
public class RedisStudyController {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public List<Study> studies;

    @PostConstruct
    public void init(){
        studies = Optional.ofNullable(studies).orElse(new ArrayList<>());
        studies.add(new Study("kafka",5));
        studies.add(new Study("hadoop",6));
        studies.add(new Study("spark",7));
    }

    @RequestMapping("/testString")
    public void testString(){
        redisTemplate.opsForValue().set("studyString",studies);
    }

    @RequestMapping("/testList")
    public void testList(){
        Long list = redisTemplate.opsForList().leftPushAll("studyList", studies);
        System.out.println(list);
    }
}
