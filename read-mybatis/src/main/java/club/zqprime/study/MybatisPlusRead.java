package club.zqprime.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("club.zqprime.study.mapper")
@SpringBootApplication
public class MybatisPlusRead {
    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusRead.class,args);
    }
}
