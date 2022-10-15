package club.zqprime.generator.script;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateUser {
      public static Map<String,String> getUsers() {

        String s = "      nacos\t36X8m%3EDKooMcv8\n" +
                "         xxl-job\tXxl_job@2021-10-23.com\n" +
                "         sentinel\tznf93HQr66iA&BQs\n" ;
        final String[] strings = s.split("\\n");
        final List<String> list = Arrays.asList(strings);
        Map<String,String> data = new HashMap<String, String>();
        list.forEach(e->{
            final String[] split = e.split("\\t");
            data.put(split[0].trim(),split[1].trim());
        });
        return data;
    }
    public static void main(String[] args) {
        Map<String,String> users = getUsers();
        users.forEach((k,v)->{
            //创建用户
            String sql = "CREATE user '"+k+"'@'%' IDENTIFIED BY '"+v+"' PASSWORD EXPIRE NEVER;";
            String sql2 = "CREATE DATABASE IF NOT EXISTS " + k + " CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';";
            //授权资源
            String sql3 = " GRANT Alter, Alter Routine, Create, Create Routine, Create Temporary Tables, Create View, Delete," +
                    " Drop, Event, Execute, Grant Option, Index, Insert, Lock Tables, References, Select, Show View, " +
                    "Trigger, Update ON `" + k + "`.* TO `" + k + "`@`%`;";
            System.out.println(sql);
//            System.out.println(sql2);
            System.out.println(sql3);
        });
        String sql3 = "flush privileges;";
        System.out.println(sql3);
    }



}
