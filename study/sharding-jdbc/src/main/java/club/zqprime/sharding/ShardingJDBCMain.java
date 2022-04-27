package club.zqprime.sharding;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = "club.zqprime.sharding.mapper")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class ShardingJDBCMain {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJDBCMain.class, args);
    }
}
