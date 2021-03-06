package club.zqprime.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
public class SimpleServiceDoor {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/foo")
    public String foo(){
        String url = "http://simple-server/foo";
        return restTemplate.getForObject(url,String.class);
    }

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        String url = "http://simple-server/hello/"+name;
        return restTemplate.getForObject(url,String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleServiceDoor.class,args);
    }
}
