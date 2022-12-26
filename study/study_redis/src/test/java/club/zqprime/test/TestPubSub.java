package club.zqprime.test;

import club.zqprime.redis.RedisMain;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zqprime
 * @date 2022/12/24 16:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisMain.class})
public class TestPubSub {


}
