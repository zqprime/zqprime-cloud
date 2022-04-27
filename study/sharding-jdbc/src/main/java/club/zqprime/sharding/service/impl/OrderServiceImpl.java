package club.zqprime.sharding.service.impl;

import club.zqprime.sharding.mapper.OrderMapper;
import club.zqprime.sharding.model.Order;
import club.zqprime.sharding.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
