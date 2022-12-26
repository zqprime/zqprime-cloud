package club.zqprime.redis.sub;

import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    public void onMessage(String message){
        System.out.println("接收消息：" + message);
    }
}