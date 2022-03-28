package club.zqprime.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Configuration
public class ZookeeperConfig {

    @Bean(name = "zookeeperCluster")
    public ZooKeeper zookeeper() throws IOException, InterruptedException {
        String zkServerClusterConnect = "127.0.0.1:12181,127.0.0.1:22181,127.0.0.1:32181";
        CountDownLatch downLatch = new CountDownLatch(1);
        ZooKeeper zooKeeper = new ZooKeeper(zkServerClusterConnect, 50000000,
            watchedEvent -> {
                System.out.println(watchedEvent.getState());
                downLatch.countDown();
            }
        );
        downLatch.await();
        return zooKeeper;
    }
}
