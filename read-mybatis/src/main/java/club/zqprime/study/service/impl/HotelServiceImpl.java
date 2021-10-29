package club.zqprime.study.service.impl;

import club.zqprime.study.dao.Hotel;
import club.zqprime.study.mapper.HotelMapper;
import club.zqprime.study.service.HotelService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.provider.DynamicDataSourceProvider;
import com.baomidou.dynamic.datasource.toolkit.DynamicDataSourceContextHolder;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class HotelServiceImpl extends ServiceImpl<HotelMapper, Hotel> implements HotelService{

    @Resource
    private ApplicationContext context;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
//    @DS("slave_1")
    @DS("#header.source")
    public boolean saveTest(Hotel hotel){
        DynamicDataSourceProvider bean = context.getBean(DynamicDataSourceProvider.class);
        String peek = DynamicDataSourceContextHolder.peek();
        System.out.println(peek);
        return saveOrUpdate(hotel);
    }
}
