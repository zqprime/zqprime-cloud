package club.zqprime.study.controller;

import club.zqprime.study.dao.Hotel;
import club.zqprime.study.service.HotelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {

    @Resource
    private HotelService hotelService;

    @RequestMapping(value = "/getHotelList")
    public List<Hotel> getHotelList(){
        return hotelService.list();
    }
}
