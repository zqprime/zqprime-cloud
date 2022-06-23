package club.zqprime.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.util.UUID;

public class FooPoolObjectFactory extends BasePooledObjectFactory<Foo> {

    @Override
    public Foo create() throws Exception {
        return new Foo(UUID.randomUUID().toString());
    }

    @Override
    public PooledObject<Foo> wrap(Foo obj) {
        return new DefaultPooledObject<>(obj);
    }

}
