package club.zqprime.test;

import club.zqprime.redis.RedisMain;
import club.zqprime.redis.model.Study;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisMain.class})
public class TestRedis {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public List<Study> studies;

    @PostConstruct
    public void init(){
        studies = Optional.ofNullable(studies).orElse(new ArrayList<>());
        studies.add(new Study("kafka",5));
        studies.add(new Study("hadoop",6));
        studies.add(new Study("spark",7));
        studies.add(new Study("flink",3));
    }


    @Test
    public void testSetString(){
        redisTemplate.opsForValue().set("studyString",studies);
    }

    @Test
    public void testSetList(){
        Long list = redisTemplate.opsForList().leftPushAll("studyList", studies);
//        redisTemplate.opsForList().leftPushAll("studyList", studies);
//        redisTemplate.opsForList().leftPushAll("studyList", studies.get(0));
//        redisTemplate.opsForList().leftPushAll("studyList", studies.get(1));
        System.out.println(list);
    }

   @Test
    public void testGetList(){
        Object list = redisTemplate.opsForList().leftPop("studyList");
       Object index = redisTemplate.opsForList().index("studyList", 0);
       System.out.println(index);
    }

    @Test
    public void testSetSet(){
        Long set1 = redisTemplate.opsForSet().add("studySet", studies.get(0));
        Long set2 = redisTemplate.opsForSet().add("studySet", studies.get(1));
        Long set3 = redisTemplate.opsForSet().add("studySet", studies.get(2));
        Long set4 = redisTemplate.opsForSet().add("studySet", studies.get(3));
        Long setAll = redisTemplate.opsForSet().add("studySet", studies);
        System.out.println(set1);
    }

    @Test
    public void testGetSet(){
        Boolean isMember = redisTemplate.opsForSet().isMember("studySet", studies);
        System.out.println(isMember);
    }

    @Test
    public void testSetHash(){
        studies.forEach(e->{
            Long hash = redisTemplate.opsForHash().increment("studyHash", e, new Random().nextInt(20));
            System.out.println(hash);
        });
    }
    @Test
    public void testGetHash(){
        studies.forEach(e->{
            Object hash = redisTemplate.opsForHash().get("studyHash", e);
            System.out.println(hash);
        });
        System.out.println(redisTemplate.opsForHash().get("studyHash", studies.get(0)));
        Map<Object, Object> entries = redisTemplate.opsForHash().entries("studyHash");
        System.out.println(entries);
    }

}
