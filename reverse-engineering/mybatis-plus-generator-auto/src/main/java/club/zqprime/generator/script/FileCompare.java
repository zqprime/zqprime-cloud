package club.zqprime.generator.script;

import java.io.File;

import java.util.ArrayList;
import java.util.List;


public class FileCompare {
    public static void main(String[] args) {
        List<String> localJars = getJars("D:\\git\\payment-system\\jlkj-sms\\target\\jlkj-sms\\WEB-INF\\lib");
        List<String> remoteJars = getJars("D:\\work\\xxxx\\sms\\jlkj-sms\\WEB-INF\\lib");

        System.out.println(remoteJars);
        System.out.println(localJars);
        //本地上传到远程
        final boolean removeAll = localJars.removeAll(remoteJars);
        localJars.forEach(System.out::println);


    }

    public static List<String> getJars(String dir){
        File file = new File(dir);
        final File[] files = file.listFiles();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            list.add(files[i].getName());
        }
        return list;
    }
}
