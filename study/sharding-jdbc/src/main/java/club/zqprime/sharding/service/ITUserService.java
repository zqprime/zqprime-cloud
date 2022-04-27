package club.zqprime.sharding.service;

import club.zqprime.sharding.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author baomidou
 * @since 2022-04-27
 */
@Transactional
public interface ITUserService extends IService<TUser> {

}
