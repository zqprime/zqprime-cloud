package club.zqprime.test;

import club.zqprime.redis.RedisMain;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


/**
 * @author zqprime
 * @date 2022/12/24 16:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisMain.class})
public class TestPubSub {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Data
    public static class A{
        private String id;
        private String tableId;
    }

    @Test
    public void testListStream(){
        final A obj = new A();
        obj.setId("xxxx|");
        obj.setTableId("uuuuu");
        redisTemplate.opsForValue().set("haha", JSON.toJSONString(obj));

    }


    @Test
    public void getValue(){

        final String haha = (String) redisTemplate.opsForValue().get("haha");

        final A object = JSON.parseObject(haha, A.class);
        System.out.println(object);
    }

}
