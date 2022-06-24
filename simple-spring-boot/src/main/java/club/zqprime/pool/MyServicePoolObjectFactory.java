package club.zqprime.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.Date;
import java.util.UUID;

public class MyServicePoolObjectFactory extends BasePooledObjectFactory<MySource> {

    @Override
    public MySource create() throws Exception {
        return new MySource(UUID.randomUUID().toString());
    }

    @Override
    public PooledObject<MySource> wrap(MySource myService) {
        return new DefaultPooledObject<>(myService);
    }

    @Override
    public void destroyObject(final PooledObject<MySource> p)
            throws Exception  {
        final String format = p.getObject().getDateFormat().format(new Date());
        System.out.println(format +"池化对象销毁："+p.getObject().getName());
    }
}
