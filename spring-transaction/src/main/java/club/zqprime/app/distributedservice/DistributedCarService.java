package club.zqprime.app.distributedservice;

import club.zqprime.app.entity.Prd01Car;
import club.zqprime.app.service.IPrd01CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Component
public class DistributedCarService {

    @Resource
    private IPrd01CarService prd01CarService;

    private final AtomicInteger ai = new AtomicInteger(0);


//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public boolean xxxSupport(String id){
        final String name = TransactionSynchronizationManager.getCurrentTransactionName();
        log.info("xxxSupport========================================："+name);
        log.info("步骤{}",3);
        Prd01Car car = prd01CarService.getById(id);

        log.info("步骤{}",4);
        Integer count = car.getCount();

        car.setCount(++count);
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("步骤{}",5);
        final boolean update = prd01CarService.updateById(car);
        log.info("步骤{}",6);
        final int times = ai.incrementAndGet();
        log.info("============方法执行了：{}次了,count:{},结果：{}============",times,count,update);
        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        log.info("步骤{},{}",7,5/0);
        return true;
    }
}
