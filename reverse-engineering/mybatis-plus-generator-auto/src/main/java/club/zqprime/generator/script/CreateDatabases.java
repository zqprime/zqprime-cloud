package club.zqprime.generator.script;

import java.util.HashMap;

public class CreateDatabases {

    private static HashMap<String,String> users = new HashMap<>();
    public static void main(String[] args) {
        users.put("lky_admin","3eTT15YwmwP%JS84");

        users.put("mall_center","9Kt&IMBJAI%5VeePgHyI");
        users.put("mall_gexiancun","8Ha*aTwV*7B%ywjVZ!1O");
        users.put("mall_wulvzhou","7Gm#xLE?PmmL.DJO%%~z");
        users.put("mall_xinbang","7Yw$76@#D^z31oHk3XBg");

        users.put("upms_center","7PdLiXCadVUtnuZ@");
        users.put("upms_wulvzhou","3Jx!@4D*EnUoT9eWcRsH");
        users.put("upms_xinbang","5Ko?WOZ#?tH?KK~tUiYJ");
        users.put("upms_gexiancun","4Il*qq?whOY02Nlc?Ny5");

        users.put("crs_gexiancun","9Yg^R?a*r.1D&BOGcj9C");
        users.put("crs_wulvzhou","6Ly%OK5L~qYUAWiAF3vv");
        users.put("crs_xinbang","3Le.iBmx.nrBAYBobMw?");

        users.put("gms_group","2Zj0LOu%ikK#!54v");

        users.forEach((k,v)->{
            String sql = "CREATE user '"+k+"'@'%' IDENTIFIED BY '"+v+"' PASSWORD EXPIRE NEVER;";
            String sql2 = "GRANT ALL PRIVILEGES ON "+k+".* TO '"+k+"'@'%';";
            String sql3 = "flush privileges;";
            String sql4 = "CREATE DATABASE IF NOT EXISTS " + k + " CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';";
            String sql5 = " GRANT Alter, Alter Routine, Create, Create Routine, Create Temporary Tables, Create View, Delete," +
                    " Drop, Event, Execute, Grant Option, Index, Insert, Lock Tables, References, Select, Show View, " +
                    "Trigger, Update ON `" + k + "`.* TO `" + k + "`@`%`;";
//            System.out.println(sql);
//            System.out.println(sql2);
//            System.out.println(sql3);
            System.out.println(sql);
        });
    }

}
