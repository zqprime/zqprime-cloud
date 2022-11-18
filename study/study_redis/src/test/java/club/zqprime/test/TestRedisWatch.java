package club.zqprime.test;

import club.zqprime.redis.RedisMain;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisMain.class})
public class TestRedisWatch {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void testWatch() {
        redisTemplate.opsForValue().set("haha","hehe");
        final Thread thread = new Thread(() -> {
            redisTemplate.setEnableTransactionSupport(true);
            redisTemplate.watch("haha");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redisTemplate.multi();
            redisTemplate.delete("haha");
            redisTemplate.opsForValue().set("haha", "jaja");
            redisTemplate.opsForValue().set("haha", "jaja2");
            redisTemplate.opsForValue().set("haha", "jaja3");
            redisTemplate.opsForValue().set("haha", "jaja4");
            redisTemplate.opsForValue().set("haha", "jaja5");
            redisTemplate.opsForValue().set("haha", "jaja6");
            final List<Object> exec = redisTemplate.exec();
            log.info("线程：{},结果：{}",Thread.currentThread().getName(),exec);
            redisTemplate.setEnableTransactionSupport(false);

        },"线程一");

        Thread thread1 = new Thread(() -> {

            redisTemplate.setEnableTransactionSupport(true);
            redisTemplate.watch("haha");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redisTemplate.multi();
            redisTemplate.delete("haha");
            redisTemplate.opsForValue().set("haha", "lala");
            redisTemplate.opsForValue().set("haha", "lala2");
            redisTemplate.opsForValue().set("haha", "lala3");
            redisTemplate.opsForValue().set("haha", "lala4");
            redisTemplate.opsForValue().set("haha", "lala5");
            final List<Object> exec = redisTemplate.exec();
            log.info("线程：{},结果：{}",Thread.currentThread().getName(),exec);
            redisTemplate.setEnableTransactionSupport(false);
        },"线程二");

        thread.start();
        thread1.start();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }




    @Test
    public void testHashWatch() {
        redisTemplate.opsForHash().put("haha","A",0);

        final Thread thread = new Thread(() -> {
            redisTemplate.setEnableTransactionSupport(true);
            redisTemplate.watch("haha");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redisTemplate.multi();
//            redisTemplate.opsForHash().put("haha","B",0);
            redisTemplate.delete("haha");
            final List<Object> exec = redisTemplate.exec();
            log.info("线程：{},结果：{}",Thread.currentThread().getName(),exec);
            redisTemplate.setEnableTransactionSupport(false);

        },"线程一");

        Thread thread1 = new Thread(() -> {
            redisTemplate.setEnableTransactionSupport(true);
            redisTemplate.watch("haha");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            redisTemplate.multi();
            redisTemplate.delete("haha");
            List<Object> exec = redisTemplate.exec();
            log.info("线程：{},结果：{}",Thread.currentThread().getName(),exec);
            redisTemplate.setEnableTransactionSupport(false);

        },"线程二");

        thread.start();
        thread1.start();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testInt(){
//        redisTemplate.opsForValue().set("a",1);
//        final Integer a = (Integer)redisTemplate.opsForValue().get("a");
//        System.out.println(a);
        redisTemplate.opsForValue().increment("a");
        final Integer b = (Integer)redisTemplate.opsForValue().get("a");
        System.out.println(b);
    }
}
