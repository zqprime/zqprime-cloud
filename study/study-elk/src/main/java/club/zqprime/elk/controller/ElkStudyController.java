package club.zqprime.elk.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author zqprime
 */
@Slf4j
@Component
public class ElkStudyController implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args){
        for (int i = 0; i < 10000; i++) {
            log.info("logstash-zqprime-elk 测试初始一些日志吧！  "+i);
        }

    }
}
