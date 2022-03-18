package club.zqprime.elk;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithElkApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWithElkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Logger logger = LoggerFactory.getLogger(SpringBootWithElkApplication.class);
        logger.info("elk-study测试log");

        for (int i = 0; i < 10; i++) {
            logger.warn("elk something wrong. id={}; name=Ryan-{};", i, i);
        }
    }
}