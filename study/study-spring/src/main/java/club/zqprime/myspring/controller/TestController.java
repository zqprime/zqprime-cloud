package club.zqprime.myspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zqprime
 * @description
 * @date 2023/6/25 8:41
 */
@RestController
@RequestMapping("/testController")
public class TestController {
    @RequestMapping("/getUUID")
    public String getUUID(){
        return UUID.randomUUID().toString();
    }
    @RequestMapping("/getUUID2")
    public String getUUID2(){
        return UUID.randomUUID().toString();
    }
}
