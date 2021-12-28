package club.zqprime.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping(value = "/test")
@RestController
public class TestController {

    @SentinelResource(value = "getUUID")
    @GetMapping(value = "/getUUID")
    public String getUUID(String name,String value) {
        return UUID.randomUUID().toString()+"\t"+name+"\t"+value;
    }
}