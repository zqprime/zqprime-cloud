package club.zqprime.sharding.service.impl;

import club.zqprime.sharding.entity.TUser;
import club.zqprime.sharding.mapper.TUserMapper;
import club.zqprime.sharding.service.ITUserService;
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
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
