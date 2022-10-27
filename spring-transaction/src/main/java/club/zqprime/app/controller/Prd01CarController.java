package club.zqprime.app.controller;

import club.zqprime.app.entity.Prd01Car;
import club.zqprime.app.service.IPrd01CarService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * <p>
 * 汽车 前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-10-11
 */
@RestController
@RequestMapping("/prd01Car")
public class Prd01CarController {

    @Resource
    private IPrd01CarService prd01CarService;

    @GetMapping("/list")
    public List<Prd01Car> findList(){
        final List<Prd01Car> list = prd01CarService.list();
        System.out.println(list);
        return list;
    }


    @GetMapping("/removeAll")
    public boolean removeAll(){
        List<Prd01Car> list = prd01CarService.list();
        return prd01CarService.removeBatchByIds(list.stream().map(Prd01Car::getId).collect(Collectors.toSet()));
    }

    @GetMapping("/saveList/{count}")
    public List<Prd01Car> saveList(@PathVariable(value = "count") int count){
        List<Prd01Car> cars = new ArrayList<>();
        for (int i = 0; i <count ; i++) {
            Prd01Car car = new Prd01Car();
            cars.add(car);
            car.setName(UUID.randomUUID().toString());
            car.setPrice(BigDecimal.valueOf(Math.toRadians(100000)));
        }
        prd01CarService.saveBatch(cars);
        return prd01CarService.listByIds(cars.stream().map(Prd01Car::getId).collect(Collectors.toSet()));
    }
}
