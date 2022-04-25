package club.zqprime.sharding.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
@RequestMapping("/test")
@RestController
public class TestController {

    @Resource
    private DataSource dataSource;

    @RequestMapping(value = "/testDataSource")
    public void testDataSource(){
        System.out.println(dataSource);
        System.out.println("哈哈");
    }


}
