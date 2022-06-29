package club.zqprime.generator.script;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CreateDatabasesScript {
    public static void main(String[] args) {
        final File file = new File("D:\\服务器\\qmx测试\\汉海数据");
        final File[] files = file.listFiles();
        assert files != null;
        List<String> ex = Arrays.asList("xxl_job","nacos");
        List<String> list = Arrays.stream(files).map(e->e.getName().replace(".sql","")).filter(e->!ex.contains(e)).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(list.size());
        list.forEach(e->{
            String sql = "CREATE DATABASE IF NOT EXISTS " + e + " CHARACTER SET 'utf8mb4' COLLATE 'utf8mb4_general_ci';";
            System.out.println(sql);
        });
    }
}
