package club.zqprime.server;

import cn.hutool.core.util.RandomUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

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

    @RequestMapping("/getRandomString")
    public String getRandomString(String haha,String hehe){
        return UUID.randomUUID()+":"+haha+":"+hehe;
    }

    @RequestMapping("/postString")
    public String postString(@RequestBody Map<String,String> map){
        return JSONObject.toJSONString(map);
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleServiceDoor.class,args);
    }
}
