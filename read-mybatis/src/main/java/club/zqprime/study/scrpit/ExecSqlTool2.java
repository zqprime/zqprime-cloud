package club.zqprime.study.scrpit;

import cn.hutool.core.thread.RejectPolicy;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
/***
 * 处理出错的部分
 * @author zqprime
 * @date 2022/10/14 16:55
 */
@Slf4j
public class ExecSqlTool2 {

    private final ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5,30,
                                                              TimeUnit.MINUTES,new ArrayBlockingQueue<>(2000),
                Executors.defaultThreadFactory(), RejectPolicy.CALLER_RUNS.getValue());

    private final String ip ,port,user,password,explain="#DATABASE";

    public ExecSqlTool2(String ip, String port, String user, String password) {
        this.ip = ip;
        this.port = port;
        this.user = user;
        this.password = password;
    }
    public void execScriptInServer(String sqlScript,String operation){
        List<String> list = new ArrayList<>();
        list.add("cmd");
        String sql  = "C: & cd C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin & mysql"+
                " -h "+ip+" -u"+user +" -P "+port +" -p"+password+" -e "+"\""+sqlScript+"\"";
        list.add("/c");
        System.out.println(sql);
        list.add(sql);
        final ProcessBuilder builder = new ProcessBuilder(list);
        try {
            Process process = builder.start();
            readProcessOutput(process.getInputStream(), System.out);
            int state = process.exitValue();
            log.info("{}完成,状态：{}",operation,state);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SneakyThrows
    public void execScriptInServer(List<String> databases, String sqlScript,String operationMsg,String path){
        CountDownLatch downLatch = new CountDownLatch(databases.size());
        AtomicInteger times = new AtomicInteger(0);
        for (String database : databases) {
            executor.execute(()->{
                List<String> list = new ArrayList<>();
                list.add("cmd");
                String sql  = "C: & cd C:\\Program Files\\MySQL\\MySQL Server 8.0\\bin & mysql"+
                        " -h "+ip+" -u"+user +" -P "+port +" -p"+password+" -e "+"\""+sqlScript.replaceAll(explain,database)+"\"";
                list.add("/c");
                System.out.println(sql);
                list.add(sql);
                final ProcessBuilder builder = new ProcessBuilder(list);
                try {
                    Process process = builder.start();
                    readProcessOutput(process.getInputStream(), System.out);
                    int state = process.exitValue();
                    log.info("{}{}完成,状态：{}",operationMsg,database,state);
                    if(state == 0){
                        int get = times.incrementAndGet();
                        log.info("共成功{}个",get);
                    }else {
                        if(null != path){
                            //执行失败了
                            ExecSqlFile.execSqlFile(ip,port,database,user,password,path);
                        }
                    }
                    downLatch.countDown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
        downLatch.await();
        log.info("==============================");
        log.info("source共成功{}个",times.get());
        log.info("==============================");
    }

    @SneakyThrows
    public void execMysql(List<String> databases, String sqlScript,String msg,String path){
        execScriptInServer(databases,sqlScript,msg,path);
    }

    @SneakyThrows
    public void execMysqldump(List<String> databases, String sqlScript,String msg,String path){
        execScriptInServer(databases,sqlScript,msg,path);
    }


    private void readProcessOutput(InputStream inputStream, PrintStream out) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("GBK")));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("-end");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
