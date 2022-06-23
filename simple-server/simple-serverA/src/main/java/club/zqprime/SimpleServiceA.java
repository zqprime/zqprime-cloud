package club.zqprime;

import club.zqprime.server.DemoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleServiceA {
    @Autowired
    private DemoServer server;
    @RequestMapping("/foo")
    public String foo(){
        return "barA";
    }

    @GetMapping("/hello/{name}")
    public String apiHello(@PathVariable String name) throws Exception {
        return server.sayHello(name);
    }
    public static void main(String[] args) {
        SpringApplication.run(SimpleServiceA.class,args);
    }
}
