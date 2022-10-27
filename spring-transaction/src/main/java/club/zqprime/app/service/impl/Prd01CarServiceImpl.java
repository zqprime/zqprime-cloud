package club.zqprime.app.service.impl;

import club.zqprime.app.entity.Prd01Car;
import club.zqprime.app.mapper.Prd01CarMapper;
import club.zqprime.app.service.IPrd01CarService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;

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


    @Override
    public boolean myTest() {
        final String name = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("当前事务："+name);
        String key = "testKey";
        final RLock lock = redissonClient.getLock(key);
        lock.lock();
        try {
            log.info("hahaah:{}",Thread.currentThread().getName());
        }finally {
            lock.unlock();
        }
        return true;
    }
}
