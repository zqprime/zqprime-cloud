package club.zqprime.sharding.service.impl;

import club.zqprime.sharding.entity.TOrder;
import club.zqprime.sharding.mapper.TOrderMapper;
import club.zqprime.sharding.service.ITOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author baomidou
 * @since 2022-04-27
 */
@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements ITOrderService {

}
