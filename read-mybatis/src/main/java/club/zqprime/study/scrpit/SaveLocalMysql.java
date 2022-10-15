package club.zqprime.study.scrpit;

import org.junit.Test;

import java.util.List;

public class SaveLocalMysql {
    final static ExecSqlTool2 execSqlTool2 = new ExecSqlTool2("127.0.0.1", "3306", "root", "root");



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
        execSqlTool2.execMysql(Test230Databases.getDatabases(),sqlScript,"数据传输",baseFile);
        execSqlTool2.execScriptInServer("set global innodb_strict_mode = 1;","设置引擎");
    }
}
