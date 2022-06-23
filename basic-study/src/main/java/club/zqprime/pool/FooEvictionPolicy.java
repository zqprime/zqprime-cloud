package club.zqprime.pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.EvictionConfig;
import org.apache.commons.pool2.impl.EvictionPolicy;

public class FooEvictionPolicy implements EvictionPolicy<Foo> {

    @Override
    public boolean evict(EvictionConfig config, PooledObject<Foo> underTest, int idleCount) {
        System.out.println("定时检查：config:"+config+" idleCount:"+idleCount+" underTest" +underTest);
        // todo  定期检查对象某些功能是否可用
        return true;
    }
}
