package club.zqprime.test;

import club.zqprime.redis.RedisMain;
import club.zqprime.redis.model.Book;
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

    public List<Book> books;

    @PostConstruct
    public void init(){
        studies = Optional.ofNullable(studies).orElse(new ArrayList<>());
        books = Optional.ofNullable(books).orElse(new ArrayList<>());
        studies.add(new Study("kafka",5));
        studies.add(new Study("hadoop",6));
        studies.add(new Study("spark",7));
        studies.add(new Study("flink",3));

        books.add(new Book("Chinese","hahahaha"));
        books.add(new Book("English","wuwuwuwu"));
    }


    @Test
    public void testSetString(){
        redisTemplate.opsForValue().set("jc#studyString#12323#haha",studies);
        redisTemplate.opsForValue().set("jc#studyString#12365#lolo",studies);
    }

    @Test
    public void testDeleteKey(){
        Set<String> keys = redisTemplate.keys("jc#studyString#*");
        System.out.println(keys);
        assert keys != null;
        keys.forEach(redisTemplate::delete);
    }

    @Test
    public void testSetList(){
        Long list = redisTemplate.opsForList().leftPushAll("valueList", studies);


        System.out.println(list);
//        System.out.println(list2);
    }

   @Test
    public void testGetList(){

    }
//
//    @Test
//    public void testSetSet(){
//        Long set1 = redisTemplate.opsForSet().add("studySet", studies.get(0));
//        Long set2 = redisTemplate.opsForSet().add("studySet", studies.get(1));
//        Long set3 = redisTemplate.opsForSet().add("studySet", studies.get(2));
//        Long set4 = redisTemplate.opsForSet().add("studySet", studies.get(3));
//        Long setAll = redisTemplate.opsForSet().add("studySet", studies);
//        System.out.println(set1);
//    }

    @Test
    public void testGetSet(){
        Boolean isMember = redisTemplate.opsForSet().isMember("studySet", studies);
        System.out.println(isMember);
    }

    @Test
    public void testDelString(){
        Boolean set = redisTemplate.delete("studySet");
        System.out.println(set);
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

    @Test
    public void testSetHash2(){
        studies.forEach(e->{
            Long hash = redisTemplate.opsForHash().increment("studyHash", e, new Random().nextInt(20));
            System.out.println(hash);
        });
    }

}
