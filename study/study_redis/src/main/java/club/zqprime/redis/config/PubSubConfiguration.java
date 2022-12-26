package club.zqprime.redis.config;

import club.zqprime.redis.sub.MessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

@Configuration
public class PubSubConfiguration {

    @Bean
    public MessageListenerAdapter getMessageListenerAdapter(MessageListener messageListener){
        return new MessageListenerAdapter(messageListener, "onMessage");
    }

    @Bean
    public RedisMessageListenerContainer getRedisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory, MessageListenerAdapter messageListenerAdapter){
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);

        redisMessageListenerContainer.addMessageListener(messageListenerAdapter, new PatternTopic("haha"));
        return redisMessageListenerContainer;
    }
}
