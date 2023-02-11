package club.zqprime;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SimpleServiceB {


    public static void main(String[] args) {
        SpringApplication.run(SimpleServiceB.class,args);
    }
}
