package club.zqprime.app.service.impl;

import club.zqprime.app.distributedservice.DistributedCarService;
import club.zqprime.app.entity.Prd01Car;
import club.zqprime.app.listener.TransactionEvent;
import club.zqprime.app.listener.TransactionListener;
import club.zqprime.app.mapper.Prd01CarMapper;
import club.zqprime.app.service.IPrd01CarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 汽车 服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-10-11
 */
@Service
@Slf4j
public class Prd01CarServiceImpl extends ServiceImpl<Prd01CarMapper, Prd01Car> implements IPrd01CarService {

    @Resource
    private RedissonClient redissonClient;

    @Resource
    private DistributedCarService distributedCarService;

    private final AtomicInteger ai = new AtomicInteger(0);

    /**
     * 锁释放了，但是事务未提交，新的请求不会获取到之前的数据。
     * 所以有bug
     * @author zqprime
     * @date 2022/10/28 15:50
     */
    @SneakyThrows
    @Override
    public boolean myTest(String id) {
        final String name = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("当前事务："+name);
        String key = "testKey_"+id;
        final RLock lock = redissonClient.getLock(key);
        lock.lock();
        try {
            Prd01Car car = getById(id);
            final String name2 = TransactionSynchronizationManager.getCurrentTransactionName();
            log.info("当前事务testSupport*******："+name2);
            Integer count = car.getCount();
            car.setCount(++count);
            TimeUnit.MILLISECONDS.sleep(20);
            final boolean update = updateById(car);
            final int times = ai.incrementAndGet();
            log.info("============方法执行了：{}次了,count:{},结果：{}============",times,count,update);
            TimeUnit.MILLISECONDS.sleep(20);
            TimeUnit.MILLISECONDS.sleep(200);
        }finally {
            lock.unlock();
        }
        TimeUnit.MILLISECONDS.sleep(200);
        return true;
    }

    @Override
    public boolean supportsTest(String id) {
        final String name = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("supportsTest========================================："+name);
        log.info("步骤{}",1);
        String key = "testKey_"+id;
        final RLock lock = redissonClient.getLock(key);
        lock.lock();
        try {
            log.info("步骤{}",2);
            return distributedCarService.xxxSupport(id);
        }finally {
            lock.unlock();
            log.info("步骤{}",7);
        }
    }

    @Resource
    private ApplicationEventPublisher publisher;

    @Override
    public void testInterceptor(String id) {
        final Prd01Car prd01Car = new Prd01Car();
        final String uuid = UUID.randomUUID().toString();
        prd01Car.setName(uuid);
        prd01Car.setId(System.currentTimeMillis());
        save(prd01Car);
        TransactionEvent event = new TransactionEvent(uuid);
        publisher.publishEvent(event);
    }
}
