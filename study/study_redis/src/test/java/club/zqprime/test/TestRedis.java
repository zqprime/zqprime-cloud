package club.zqprime.test;

import club.zqprime.redis.RedisMain;
import club.zqprime.redis.model.Book;
import club.zqprime.redis.model.Study;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.CompareTo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;

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
    public void testListStream(){
        final String collect = studies.stream()
                .map(Study::getName)
                .sorted(String::compareTo)
                .collect(Collectors.joining("-"));
        System.out.println(collect);
    }

    @Test
    public void testSetString(){
        redisTemplate.opsForValue().set("jc#studyString#12323#haha", JSON.toJSONString(studies));
        redisTemplate.opsForValue().set("jc#studyString#12365#lolo",JSON.toJSONString(studies));
    }

    @Test
    public void testGetString(){
        final Object o = redisTemplate.opsForValue().get("jc#studyString#12323#haha");
        final Object o1 = redisTemplate.opsForValue().get("jc#studyString#12365#lolo");
        assert o != null;
        System.out.println(JSONArray.parseArray(o.toString(),Study.class));
        assert o1 != null;
        System.out.println(JSONArray.parseArray(o1.toString(),Study.class));
        System.out.println(o1);
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

       final List<Object> valueList = redisTemplate.opsForList().range("valueList", 0, -1);
       System.out.println(valueList);
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
    public void testDelHash(){
        redisTemplate.delete("studyHashnumb");
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
//        studies.forEach(e->{
//            Long hash = redisTemplate.opsForHash().increment("studyHashnumber", e, new Random().nextInt(20));
//            System.out.println(hash);
//        });
        final Object o = redisTemplate.opsForHash().get("studyHashnumb", "xxx");
        System.out.println(o);
        studies.forEach(e->{
            Long hash = redisTemplate.opsForHash().increment("studyHashnumber", e, - new Random().nextInt(20));
            System.out.println(hash);
        });
    }




    @Test
    public void testSetHashObject(){
        studies.forEach(e->{
//            Long hash = redisTemplate.opsForHash().increment("studyHash", e, new Random().nextInt(20));
            redisTemplate.opsForHash().put("studyHash",e.getName(),JSON.toJSONString(e));
        });
    }

    @Test
    public void testGetHashObject(){
        final Object o = redisTemplate.opsForHash().get("studyHash", "hadoop");
        System.out.println(o);
    }

    @Test
    public void testStringTransaction(){
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.watch("haha");
        redisTemplate.multi();
        redisTemplate.delete("haha");

//        redisTemplate.opsForValue().set("haha","3");
        int i = 1/0;
        redisTemplate.exec();
        redisTemplate.setEnableTransactionSupport(false);
    }

    @Test
    public void testKeyGq() throws InterruptedException {
        redisTemplate.opsForValue().set("baike", "100", 8, TimeUnit.SECONDS);

        final Boolean baike = redisTemplate.hasKey("baike");
        System.out.println(baike != null && baike);

        TimeUnit.SECONDS.sleep(9);
        final Boolean baike2 = redisTemplate.hasKey("baike");
        System.out.println(baike2 != null && baike2);
    }
}
