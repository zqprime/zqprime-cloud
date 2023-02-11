package club.zqprime.service;
import club.zqprime.basic.entity.Car;
import lombok.extern.slf4j.Slf4j;
import club.zqprime.basic.service.ICarService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.config.annotation.Service;

import java.math.BigDecimal;
import java.util.Date;
@Slf4j
//@DubboService
@Service
public class CarServiceImpl implements ICarService {

    @Override
    public Car getCar() {
        Car build = Car.builder()
                .amount(new BigDecimal("56.5"))
                .name("丰田")
                .date(new Date())
                .build();
        log.info("接口的返回参数Car:{}",build);
        return build;
    }
}
