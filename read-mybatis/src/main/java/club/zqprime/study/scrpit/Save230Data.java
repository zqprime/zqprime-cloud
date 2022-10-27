package club.zqprime.study.scrpit;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;

@Slf4j
public class Save230Data {
    String ip = "10.1.11.230",user="admin",password="admin",baseFilePath="D:\\data\\bak\\";
    ExecSqlTool tool2 = new ExecSqlTool(ip,"3306",user,password);
    @Test
    public void saveDataSql(){
        tool2.saveData(Test230Databases.getDatabases(),"保存文件",baseFilePath);
    }

    @Test
    public void saveUser(){
        tool2.saveUser("保存用户","D:\\data\\230_mysql_all_users.txt");
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
            tool2.executeScript("\"SHOW GRANTS FOR "+str+";\""+" >> "+qx,"保存权限");
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
}
