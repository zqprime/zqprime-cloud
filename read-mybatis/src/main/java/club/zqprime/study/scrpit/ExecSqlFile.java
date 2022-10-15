package club.zqprime.study.scrpit;

import com.mysql.cj.jdbc.Driver;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.util.StopWatch;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class ExecSqlFile {
    private static AtomicInteger value = new AtomicInteger(0);
    public static void execSqlFile(String ip,String port,String databases,String user,String passwd,String sqlPath){
        Reader reader = null;
        try{
            final StopWatch watch = new StopWatch();
            watch.start();
            //获取数据源
            System.out.println("执行脚本："+databases);
            final Driver driver = new Driver();
            final SimpleDriverDataSource dataSource = new SimpleDriverDataSource(driver,
                    "jdbc:mysql://"+ip+":"+port+"/"+ databases +"?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8",
                    user,passwd);
            final Connection connection = DataSourceUtils.getConnection(dataSource);
            final ScriptRunner scriptRunner = new ScriptRunner(connection);
            final StringWriter writer = new StringWriter();
            final PrintWriter print = new PrintWriter(writer);
            scriptRunner.setLogWriter(print);
            scriptRunner.setErrorLogWriter(print);
            Resources.setCharset(StandardCharsets.UTF_8);
            String filePath = sqlPath+databases+".sql";
            final File file = new File(filePath);
            if(file.exists()){
                reader = new FileReader(file);
            }
            scriptRunner.runScript(reader);
            connection.close();
            watch.stop();
            int incrementAndGet = value.incrementAndGet();
            log.info("执行脚本：{},耗时:{},共成功：{}",databases,watch.getTotalTimeMillis(),incrementAndGet);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        log.info("==============================");
        log.info("script共成功{}个",value.get());
        log.info("==============================");

    }
}
