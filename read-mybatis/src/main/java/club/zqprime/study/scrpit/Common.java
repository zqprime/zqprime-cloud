package club.zqprime.study.scrpit;

import java.io.*;
import java.nio.charset.Charset;

public class Common {
    public static void readProcessOutput(InputStream inputStream, PrintStream out) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("GBK")));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("-end");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
