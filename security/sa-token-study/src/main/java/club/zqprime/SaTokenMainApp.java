package club.zqprime;

import cn.dev33.satoken.SaManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class SaTokenMainApp
{
    public static void main( String[] args )
    {
        SpringApplication.run(SaTokenMainApp.class,args);
        System.out.println("\nSa-Token-OAuth Server端启动成功");
        System.out.println("启动成功：Sa-Token配置如下：" + SaManager.getConfig());
    }
}
