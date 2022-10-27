package club.zqprime.study.scrpit;

import lombok.SneakyThrows;
import org.junit.Test;

import java.io.*;
import java.util.List;

public class SaveLocalMysql {
    final static ExecSqlTool execSqlTool = new ExecSqlTool("127.0.0.1", "3306", "root", "root");



    @Test
    public void testRemoveDatabases(){
        String sqlScript = "DROP DATABASE `#DATABASE`;";
        final List<String> databases = Test230Databases.getDatabases();
        System.out.println(databases);
        execSqlTool.execMysql(databases,sqlScript,"删除",null);
    }

    @Test
    public void testCreateDatabases(){
        String sqlScript = "CREATE DATABASE IF NOT EXISTS `#DATABASE` CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';";
        final List<String> databases = Test230Databases.getDatabases();
        System.out.println(databases);
        execSqlTool.execMysql(databases,sqlScript,"创建",null);
    }

    @Test
    public void testTransferData(){
        String baseFile = "D:/bak/";
        execSqlTool.execScriptInServer("set global innodb_strict_mode = 0;","设置引擎");
        String sqlScript = "USE `#DATABASE`;" +
                "SOURCE "+baseFile+"#DATABASE.sql;";
        execSqlTool.execMysql(Test230Databases.getDatabases(),sqlScript,"数据传输",baseFile);
        execSqlTool.execScriptInServer("set global innodb_strict_mode = 1;","设置引擎");
    }

    @Test
    public void saveUser(){
        execSqlTool.saveUser("保存用户","D:\\data\\mysql_all_users.txt");
    }

    @Test
    public void savePermission() throws IOException {
        final File file = new File("D:\\data\\230_mysql_all_users.txt");
        String qx = "D:\\data\\230_mysql_all_users.sql";
        final FileReader reader = new FileReader(file);
        final BufferedReader bufferedReader = new BufferedReader(reader);
        String str;
        while ((str = bufferedReader.readLine()) != null){
            BufferedWriter bw = new BufferedWriter(new FileWriter(qx,true));
            String[] split = str.split("@");
            bw.write("CREATE user "+str+" IDENTIFIED BY "+split[0].replaceAll("`","'")+" PASSWORD EXPIRE NEVER;\n");
            System.out.println(str);
            bw.close();
            execSqlTool.executeScript("\"SHOW GRANTS FOR "+str+";\""+" >> "+qx,"保存权限");
        }
        bufferedReader.close();
        final BufferedReader bf = new BufferedReader(new FileReader(qx));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(qx.replace(".sql","2.sql")));
        while ((str = bf.readLine()) != null){
            if(!str.endsWith(";")){
                str += ";";
            }
            str += "\n";
            bw2.write(str);
        }
        bw2.write("flush privileges;");
        bw2.close();
        bf.close();
        new File(qx).delete();
    }

    @Test
    @SneakyThrows
    public void updateUser(){
        String file = "D:/data/230_mysql_all_users2.sql";
        String script = "SOURCE "+file+";";
        execSqlTool.executeScript("\""+script+"\"","更新用户");
    }

    @Test
    @SneakyThrows
    public void removeUser(){
        final File file = new File("D:\\data\\230_mysql_all_users.txt");
        final FileReader reader = new FileReader(file);
        final BufferedReader bufferedReader = new BufferedReader(reader);
        String str;
        while ((str = bufferedReader.readLine()) != null){
            execSqlTool.executeScript("\"drop user "+str+";\"","保存权限");
        }
        bufferedReader.close();
    }
}
