package org.example;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.common.CommonController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@EnableDiscoveryClient
@SpringBootApplication
@RestController
@RequestMapping(value = "test")
public class TestSentinelLimit extends CommonController {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestSentinelLimit.class, args);
    }

    @SentinelResource(value = "getUUID", blockHandler = "handleEx")
    @RequestMapping("/getUUID")
    public String getUUID(){
        return UUID.randomUUID().toString();
    }

    public String handleEx(String msg, BlockException ex) {
        System.out.println("系统错误：msg=" + msg + ", ex: " + ex);
        return "流量限制，请稍后重试";
    }
}
