package club.zqprime.study.service.impl;

import club.zqprime.study.dao.Hotel;
import club.zqprime.study.mapper.HotelMapper;
import club.zqprime.study.service.HotelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl extends ServiceImpl<HotelMapper, Hotel> implements HotelService{

}
