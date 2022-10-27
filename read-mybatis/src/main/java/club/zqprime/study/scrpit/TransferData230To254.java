package club.zqprime.study.scrpit;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class TransferData230To254 {
    final static ExecSqlTool execSqlTool2 = new ExecSqlTool("117.139.199.254","10001","root","XmSwiwHe@GV1A0Kz_y4StKrRZ");

    @Test
    public void testRemoveDatabases(){
        String sqlScript = "DROP DATABASE `#DATABASE`;";
        final List<String> databases = Test230Databases.getDatabases();
        System.out.println(databases);
        execSqlTool2.execMysql(databases,sqlScript,"删除",null);
    }

    @Test
    public void testCreateDatabases(){
        String sqlScript = "CREATE DATABASE IF NOT EXISTS `#DATABASE` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';";
        final List<String> databases = Test230Databases.getDatabases();
        System.out.println(databases);
        execSqlTool2.execMysql(databases,sqlScript,"创建",null);
    }

    @Test
    public void testTransferData(){
        String baseFile = "D:/bak/";
        execSqlTool2.execScriptInServer("set global innodb_strict_mode = 0;","设置引擎");
        String sqlScript = "USE `#DATABASE`;" +
                "SOURCE "+baseFile+"#DATABASE.sql;";

//        execSqlTool2.execMysql(Test230Databases.getDatabases(),sqlScript,"数据传输",baseFile);
        execSqlTool2.execMysql(Collections.singletonList("cool"),sqlScript,"数据传输",baseFile);
        execSqlTool2.execScriptInServer("set global innodb_strict_mode = 1;","设置引擎");
    }



    @Test
    @SneakyThrows
    public void removeUser(){
        final File file = new File("D:\\data\\230_mysql_all_users.txt");
        final FileReader reader = new FileReader(file);
        final BufferedReader bufferedReader = new BufferedReader(reader);
        String str;
        while ((str = bufferedReader.readLine()) != null){
            execSqlTool2.executeScript("\"drop user "+str+";\"","保存权限");
        }
        bufferedReader.close();
    }

    @Test
    @SneakyThrows
    public void updateUser(){
        String file = "D:/data/230_mysql_all_users2.sql";
        String script = "SOURCE "+file+";";
        execSqlTool2.executeScript("\""+script+"\"","更新用户");
    }


}
