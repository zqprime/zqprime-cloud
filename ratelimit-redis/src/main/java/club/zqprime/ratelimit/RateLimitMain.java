package club.zqprime.ratelimit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.Scanner;


@SpringBootApplication
public class RateLimitMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String port = scanner.nextLine();
        new SpringApplicationBuilder(RateLimitMain.class)
                .profiles("server.port="+port).run(args);
    }

//    public static void main(String[] args) {
//        SpringApplication.run(RateLimitMain.class, args);
//    }

}
