package club.zqprime.server;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class SimpleServiceDoor {


    public static void main(String[] args) {
        SpringApplication.run(SimpleServiceDoor.class,args);
    }
}
