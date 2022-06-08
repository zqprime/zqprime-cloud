package club.zqprime.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleServiceA {

    @RequestMapping("/foo")
    public String foo(){
        return "barA";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleServiceA.class,args);
    }
}
