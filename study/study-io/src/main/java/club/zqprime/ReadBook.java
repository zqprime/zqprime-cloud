package club.zqprime;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadBook {
    private final static String FILE_NAME = "金瓶梅";
    private final static String FILE_PATH = "D:\\IdeaProjects\\zqprime-cloud\\study\\study-io\\src\\main\\resources\\";
    private static volatile AtomicInteger record;
    private final static Integer lines = 1;
    private final static Integer length = 80;
    private final static Semaphore sp = new Semaphore(1);
    private final static Semaphore next = new Semaphore(0);

    public static void main(String[] args) throws IOException, InterruptedException {
        record = new AtomicInteger(getRecord());
//        autoRead();
        readByBoard();
        TimeUnit.SECONDS.sleep(500000000);
    }
    public static void readByBoard(){
        read();
        listen();
    }

    public static void read(){
        new Thread(()->{
            String path = FILE_PATH+FILE_NAME+".txt";
            try(LineNumberReader numberReader = new LineNumberReader(new FileReader(path))){
                numberReader.setLineNumber(record.intValue());
                for (int i = 0; i < record.intValue(); i++) {
                    String readLine = numberReader.readLine();
                    String value = autoLines(readLine);
                    System.out.println(value);
                }
                int line = 0;
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = numberReader.readLine();
                    if(readLine != null && readLine.trim().length() > 0){
                        String value = autoLines(readLine);
                        sb.append(value).append("\n");
                    }
                    if(++line>=lines){
                        line = 0;
                        sp.acquire();
                        System.out.print(sb);
                        record.addAndGet(lines);
                        sb = new StringBuilder();
                        next.release();
                        autoSaveRecord();
                    }
                }
            }catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    public static void listen(){
        final Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if("".equals(line)){
                sp.release();
            }
        }
    }

    public static void autoSaveRecord() throws IOException {
        String path = FILE_PATH+FILE_NAME;
        final File file = new File(path);
        FileOutputStream outputStream = new FileOutputStream(file, false);
        outputStream.write(record.toString().getBytes(StandardCharsets.UTF_8));
        outputStream.close();
    }

    public static void autoRead(){
        read();
        while (true) {
            try {
                next.acquire();
                TimeUnit.SECONDS.sleep(1);
                sp.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static int getRecord() throws IOException {
        String path = FILE_PATH+FILE_NAME;
        final File file = new File(path);
        if(!file.exists()){
            boolean newFile = file.createNewFile();
            if(newFile){
                return 0;
            }else {
                throw new IOException("创建失败");
            }
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();
        bufferedReader.close();
        return line == null ? 0 : Integer.parseInt(line);
    }

    public static String autoLines(String readLine){
        List<String> str = new ArrayList<>();
        autoLine(str,readLine);
        StringBuilder sb = new StringBuilder();
        if(str.size() > 0){
            str.forEach(e->sb.append(e).append("\n"));
        }
        return sb.toString();
    }
    public static void autoLine(List<String> str,String readLine){
        if(readLine == null){
            return;
        }
        if (readLine.length() > length) {
            String substring = readLine.substring(0, length);
            str.add(substring);
            autoLine(str,readLine.substring(length));
        }else {
            str.add(readLine);
        }
    }
}
