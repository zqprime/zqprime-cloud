package club.zqprime.service;

import club.zqprime.pool.MyServiceManager;
import club.zqprime.pool.MySource;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MySourceService {
    @Resource
    private MyServiceManager serviceManager;

    public String doWork() {
        String result;
        MySource mySource = null;
        long start = System.currentTimeMillis();
        try {
            mySource = serviceManager.borrowMyService();
            mySource.doWork();
            result = "MySource:【"+mySource.getName()+"】 耗时："+(System.currentTimeMillis()-start)+"毫秒";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            if (mySource != null){
                serviceManager.returnHttpMyService(mySource);
            }
        }
        return result;
    }

    public GenericObjectPool<MySource> poolInfo(){
        return serviceManager.getPool();
    }
}
