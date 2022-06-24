package club.zqprime.pool;

import org.apache.commons.pool2.impl.AbandonedConfig;
import org.apache.commons.pool2.impl.DefaultEvictionPolicy;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.stereotype.Component;

@Component
public class  MyServiceManager {

    public MyServiceManager() {
        pool = closeableHttpClientGenericObjectPool();
    }

    public final GenericObjectPool<MySource> pool;

    public GenericObjectPool<MySource> getPool(){
        return pool;
    }

    public GenericObjectPool<MySource> closeableHttpClientGenericObjectPool() {
        GenericObjectPoolConfig<MySource> poolConfig = new GenericObjectPoolConfig<>();
        poolConfig.setMaxWaitMillis(1000 * 20);
        poolConfig.setTimeBetweenEvictionRunsMillis(3 * 60 * 60 * 1000);
        //最小空闲的时间，（此时间内不会被销毁）
        poolConfig.setMinEvictableIdleTimeMillis(3 * 60 * 60 * 1000);
        poolConfig.setMaxIdle(8);
        poolConfig.setMinIdle(5);
        poolConfig.setMaxTotal(50);
        // 设置抛弃策略
        AbandonedConfig abandonedConfig = new AbandonedConfig();
        abandonedConfig.setRemoveAbandonedOnMaintenance(true);
        abandonedConfig.setRemoveAbandonedOnBorrow(true);
        return new GenericObjectPool<>(new MyServicePoolObjectFactory(), poolConfig, abandonedConfig);
    }


    public MySource borrowMyService () throws Exception {
        return pool.borrowObject();
    }

    public void returnHttpMyService(MySource foo){
        pool.returnObject(foo);
    }
}
