package club.zqprime.generator.script;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateUser {
      public static Map<String,String> getUsers() {
        String s = "upms-center\tOvVbcxmM-BBhD8qg04\\5FVBer\n" +
                "        mall_nanjing\t3Ax.md66rDABVQ@#mYf%\n" +
                "                upms_nanjing\t9Lv*3B@ArOz0DK$ZxHBw\n" +
                "        upms_chongqing\t2Yv?!$Yfzn&AkNyXtu~P\n" +
                "        mall_center\t9Kt&IMBJAI%5VeePgHyI\n" +
                "        mall_chongqing\t8Do.4uNGXVPG@Z?X!yn.\n" +
                "                upms_hanhai\t7Os*O8x&YDtHnnicSGeF\n" +
                "        upms_fuyang\t3Ji$M8sFt4x7S0439YY9\n" +
                "        mall_fuyang\t2Pe^EKIbCLm&XqmtoCdY\n" +
                "        mall_taipingyang\t1Cz^Xiq94fmUCg?.m?nA\n" +
                "        mall_hanhai\t6Aq*!k$koLjsxM^.SI??\n" +
                "        upms_taipingyang\t4Hm&qme%ds@!euFNC6Ky\n" +
                "        upms_hefei\t1Sk$pHlyrgkN4r.2jhr~\n" +
                "                mall_hefei\t2Kj~qDa8VK#.T~$*H4hz";
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
