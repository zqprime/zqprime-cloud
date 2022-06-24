package club.zqprime.pool;

import lombok.Data;


import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class MySource{
    private String name;
    private SimpleDateFormat dateFormat;

    public MySource(String name) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.name = name;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateFormat.format(new Date())+" 对象创建成功："+this);
    }

    public void doWork(){
        Date dateStart = new Date();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Date dateEnd = new Date();
        String s = dateFormat.format(new Date())+"MySource:【"+name+"】处理完成 开始时间:["+dateStart+"] 结束时间:["+dateEnd+"] 耗时:"+(dateEnd.getTime()-dateStart.getTime()+"毫秒");
        System.out.println(s);
    }
}
