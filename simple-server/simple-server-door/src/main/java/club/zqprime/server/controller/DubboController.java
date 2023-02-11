package club.zqprime.server.controller;

import club.zqprime.basic.entity.Car;
import club.zqprime.basic.service.ICarService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/dubbo")
public class DubboController {

    @Resource
    private ICarService carService;

    @RequestMapping("/getCar")
    public Car getCar(){
        return carService.getCar();
    }
}
