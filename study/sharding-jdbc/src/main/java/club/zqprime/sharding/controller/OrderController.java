package club.zqprime.sharding.controller;

import club.zqprime.sharding.model.Order;
import club.zqprime.sharding.service.OrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequestMapping("/order")
@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/list")
    public List<Order> list(){
        return orderService.list();
    }

    @RequestMapping(value = "/saveList")
    public void saveList(int size){
        final long userId = System.currentTimeMillis();
        List<Order> orders = new ArrayList<>(size);
        final Random random = new Random();
        for (int i = 0; i < size-1; i++) {
            final Order order = new Order();
            order.setPrice(String.valueOf(random.nextInt(20)));
            order.setOrderNo(String.valueOf(i));
            order.setUserId(userId);
            order.setCreateName("批量创建："+i);
            orders.add(order);
        }
        orderService.saveBatch(orders);
    }

    @RequestMapping(value = "/save")
    public void saveOne(){
        final Random random = new Random();
            final Order order = new Order();
            order.setOrderId(1518868250881605633L);
            order.setUserId(System.currentTimeMillis());
            order.setPrice(String.valueOf(random.nextInt(20)));
            order.setOrderNo(String.valueOf(random.nextInt(20)));
            order.setCreateName("单独创建：");
        orderService.save(order);
    }
}
