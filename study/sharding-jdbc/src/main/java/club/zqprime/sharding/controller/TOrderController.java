package club.zqprime.sharding.controller;

import club.zqprime.sharding.entity.TOrder;
import club.zqprime.sharding.entity.TUser;
import club.zqprime.sharding.qo.OrderQo;
import club.zqprime.sharding.service.ITOrderService;
import club.zqprime.sharding.service.ITUserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-04-27
 */
@RestController
@RequestMapping("/tOrder")
public class TOrderController {

    @Resource
    private ITOrderService itOrderService;

    @Resource
    private ITUserService itUserService;

    @RequestMapping(value = "/save")
    public void save(){
        List<TUser> list = itUserService.list();

        if(!list.isEmpty()){
            Random random = new Random();

            Collections.shuffle(list);
            TUser user = list.get(0);
            final TOrder order = new TOrder();
            order.setPrice(random.nextDouble());
            order.setCreateTime(new Date());
            order.setUserId(user.getUserId());
            itOrderService.save(order);
        }
    }

    @RequestMapping(value = "/list")
    public List<TOrder> list(){
        return itOrderService.list();
    }

    @PostMapping(value = "/listByQo")
    public List<TOrder> list(OrderQo orderQo){
        final LambdaQueryWrapper<TOrder> lambda = new QueryWrapper<TOrder>().lambda();
        if(orderQo.getIsRange()){
            lambda.ge(!Objects.isNull(orderQo.getStartDate()),TOrder::getCreateTime,orderQo.getStartDate())
                    .le(!Objects.isNull(orderQo.getEndDate()),TOrder::getCreateTime,orderQo.getEndDate());
        }else {
            lambda.likeRight(!Objects.isNull(orderQo.getCurrent()),TOrder::getCreateTime,orderQo.getCurrent());
        }
        return itOrderService.list(lambda);
    }
}
