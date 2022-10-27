package club.zqprime.app.controller;

import club.zqprime.app.service.IPrd01CarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zqprime
 * @date 2022/10/25 16:11
 */

@RestController
@RequestMapping("/test/transaction")
public class TestTransaction {
    @Resource
    private IPrd01CarService prd01CarService;

    @RequestMapping(value = "testTransaction")
    public boolean testTransaction(){
        return prd01CarService.myTest();
    }
}
