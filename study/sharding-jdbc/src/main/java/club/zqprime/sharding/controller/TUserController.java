package club.zqprime.sharding.controller;

import club.zqprime.sharding.entity.TUser;
import club.zqprime.sharding.service.ITUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author baomidou
 * @since 2022-04-27
 */
@Controller
@RequestMapping("/tUser")
public class TUserController {
    @Resource
    private DataSource dataSource;

    @Resource
    private ITUserService itUserService;

    @RequestMapping("/foo")
    public void foo(){
        System.out.println("foo bar");
    }

    @RequestMapping("/save")
    public TUser save(){
        final TUser user = new TUser();
        user.setName("zqprime");
        itUserService.save(user);
        return user;
    }
}
