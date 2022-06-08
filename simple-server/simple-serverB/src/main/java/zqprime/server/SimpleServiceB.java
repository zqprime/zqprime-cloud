package zqprime.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleServiceB {

    @RequestMapping("/foo")
    public String foo(){
        return "barB";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleServiceB.class,args);
    }
}
