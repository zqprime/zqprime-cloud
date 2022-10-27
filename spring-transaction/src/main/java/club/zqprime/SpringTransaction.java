package club.zqprime;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("club.zqprime.app.mapper")
public class SpringTransaction
{
    public static void main( String[] args )
    {
        SpringApplication.run(SpringTransaction.class,args);
    }
}