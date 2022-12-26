package threadpool;

import java.util.concurrent.*;

/**
 * @author zqprime
 * @date 2022/12/19 16:54
 */
public class ScheduledThreadPoolExecutorTest {
    public static final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(8, Executors.defaultThreadFactory());
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            System.out.println("xxx");
        };
        System.out.println(executor.getTaskCount());
        System.out.println(executor.getActiveCount());
        executor.scheduleWithFixedDelay(runnable,2,2, TimeUnit.SECONDS);
        System.out.println("===================");
        System.out.println(executor.getTaskCount());
        System.out.println(executor.getActiveCount());
        executor.scheduleAtFixedRate(()-> System.out.println("hehe1"),2,2, TimeUnit.SECONDS);
        System.out.println("===================");
        System.out.println(executor.getTaskCount());
        System.out.println(executor.getActiveCount());
        final ScheduledFuture<?> fixedRate = executor.scheduleAtFixedRate(() -> System.out.println("hehe2"), 2, 2, TimeUnit.SECONDS);
        TimeUnit.SECONDS.sleep(5);
        System.out.println("***********************");
        fixedRate.cancel(true);
        System.out.println(executor.getTaskCount());
        System.out.println(executor.getActiveCount());
        executor.scheduleAtFixedRate(()-> System.out.println("hehe3"),2,2, TimeUnit.SECONDS);
        //        executor.remove(runnable);
        System.out.println("===================");
        System.out.println(executor.getTaskCount());
        System.out.println(executor.getActiveCount());
        TimeUnit.SECONDS.sleep(50000);
    }
}
