package club.zqprime.study.scrpit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
@Slf4j
public class HanhaiOperation {

    @Test
    public void testSaveSqlFile() throws InterruptedException {
        String ip = "rm-bp1o4f1fm9qvd3489fo.mysql.rds.aliyuncs.com",user="hanhai_root",password="Kw@PghenL8M54Zfk",baseFilePath="D:\\服务器\\汉海\\bak\\";
        List<String> databases = showDatabases();
        CountDownLatch downLatch = new CountDownLatch(databases.size());
        log.info("共备份数据库：{}",databases.size());
        for (String database : databases) {
            new Thread(()->{
                List<String> list = new ArrayList<>();
                list.add("cmd");
                String sql  = "C: & cd C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin & mysqldump.exe" +
                        " -h "+ip +" -u"+user +" -p"+password+" "+database +" > "+baseFilePath+database+".sql";
                System.out.println(sql);
                list.add("/c");
                list.add(sql);
                final ProcessBuilder builder = new ProcessBuilder(list);
                try {
                    Process process = builder.start();
                    Common.readProcessOutput(process.getInputStream(), System.out);
                    int state = process.exitValue();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                log.info("保存"+database+"完成");
                downLatch.countDown();
            }).start();
        }
        downLatch.await();
        log.info("全部同步完成");
    }

    private List<String> showDatabases(){
        List<String> strs = Arrays.asList(
                "__recycle_bin__",
                "information_schema",
                "mall_center",
                "mall_chongqing",
                "mall_fuyang",
                "mall_hanhai",
                "mall_hefei",
                "mall_nanjing",
                "mall_taipingyang",
                "mysql",
                "nacos",
                "performance_schema",
                "sentinel_metric",
                "sys",
                "upms_center",
                "upms_chongqing",
                "upms_fuyang",
                "upms_hanhai",
                "upms_hefei",
                "upms_nanjing",
                "upms_taipingyang",
                "xxl_job"
        );
        return new ArrayList<>(strs);
    }

}
