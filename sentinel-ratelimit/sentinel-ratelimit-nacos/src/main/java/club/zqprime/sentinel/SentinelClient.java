package club.zqprime.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SentinelClient {
    public static void main(String[] args) {
        SpringApplication.run(SentinelClient.class, args);
    }
}