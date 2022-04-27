package club.zqprime.generator.script;

public class CreateTable {
    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            String month = String.valueOf(i);
//            if(i < 10){
//                month = "0"+i;
//            }else {
//                month = String.valueOf(i);
//            }
            String star =  "DROP TABLE IF EXISTS `t_order_2022_"+month+"`;\n" +
                    "CREATE TABLE `t_order_2022_"+month+"` (\n" +
                    "  `id` bigint NOT NULL,\n" +
                    "  `user_id` bigint NOT NULL,\n" +
                    "\t`price` DOUBLE(5,2),\n" +
                    "\t`create_time` datetime,\n" +
                    "  PRIMARY KEY (`id`) USING BTREE\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
            System.out.println(star);
            System.out.println();
        }
    }
}
