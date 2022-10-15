//package club.zqprime.study.scrpit;
//
//import com.mysql.cj.jdbc.Driver;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.jdbc.ScriptRunner;
//import org.springframework.jdbc.datasource.DataSourceUtils;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//
//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.sql.Connection;
//import java.util.Arrays;
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//import java.util.stream.Collectors;
//
//public class ExecSqlFileTemplate {
//    public static void main(String[] args){
//        final List<String> files = getFiles();
//        final CountDownLatch downLatch = new CountDownLatch(files.size());
//        files.forEach(f->{
//            new Thread(()->{
//                Reader reader = null;
//                try{
//                    //获取数据源
//                    final Driver driver = new Driver();
//                    final SimpleDriverDataSource dataSource = new SimpleDriverDataSource(driver,
//                            "jdbc:mysql://117.139.199.254:10001/"+ f.replace("_20220811","") +"?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf-8",
//                            "root","b$6a9863edC09a9dBd2ab6b7af9f");
//                    final Connection connection = DataSourceUtils.getConnection(dataSource);
//                    final ScriptRunner scriptRunner = new ScriptRunner(connection);
//                    final StringWriter writer = new StringWriter();
//                    final PrintWriter print = new PrintWriter(writer);
//                    scriptRunner.setLogWriter(print);
//                    scriptRunner.setErrorLogWriter(print);
////                    scriptRunner.setAutoCommit(true);
//                    Resources.setCharset(StandardCharsets.UTF_8);
//
//                    String filePath = "D:\\服务器\\小程序\\sql\\sql\\"+f+".sql";
//                    final File file = new File(filePath);
//                    if(file.exists()){
//                        reader = new FileReader(file);
//                    }
//                    scriptRunner.runScript(reader);
//                    connection.close();
//                }catch (Exception e) {
//                    e.printStackTrace();
//                }finally {
//                    try {
//                        assert reader != null;
//                        reader.close();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    downLatch.countDown();
//                    System.out.println("执行结束"+f);
//                }
//            }).start();
//        });
//        try {
//            downLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("执行结束");
//    }
//}
