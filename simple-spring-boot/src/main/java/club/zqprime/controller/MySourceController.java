package club.zqprime.controller;

import club.zqprime.pool.MySource;
import club.zqprime.service.MySourceService;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mySource")
public class MySourceController{

    @Resource
    private MySourceService mySourceService;

    @RequestMapping("/testMySourcePool")
    public String testMySourcePool(){
        return mySourceService.doWork();
    }

    @RequestMapping("/poolInfo")
    public GenericObjectPool<MySource> testPoolInfo(){
        final GenericObjectPool<MySource> pool = mySourceService.poolInfo();
        return pool;
    }
}
