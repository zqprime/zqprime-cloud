package club.zqprime.study.scrpit;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@Slf4j
public class SaveSqlFile {
    @SneakyThrows
    public static void main(String[] args) {
        String ip = "10.1.11.230",user="admin",password="admin",baseFilePath="D:\\服务器\\sql\\bak\\";

        List<String> databases = Test230Databases.getDatabases();
        CountDownLatch downLatch = new CountDownLatch(databases.size());
        log.info(String.valueOf(databases.size()));
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

}
