package club.zqprime.study.service;

import club.zqprime.study.dao.Hotel;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
@DS("#source")
public interface HotelService extends IService<Hotel> {

    boolean saveTest(Hotel hotel);
}
