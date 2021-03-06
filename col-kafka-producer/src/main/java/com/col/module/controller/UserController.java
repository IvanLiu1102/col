package com.col.module.controller;

import com.col.common.utils.RandomCodeUtil;
import com.col.common.utils.RedisUtil;
import com.col.module.bean.User;
import com.col.module.service.IUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Base64;
import java.util.concurrent.*;

/**
 * Created by liu.min on 2018/11/30.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    private ExecutorService executorService = Executors.newFixedThreadPool(100);

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "success1";
    }

    @PostMapping("/insert")
    @ResponseBody
    @ApiOperation("插入用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户编号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "createTime", value = "创建时间", required = true, dataType = "Date")
    })
    public String insert(User user) {
        for (int i = 0; i < 50; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 10000; j++) {
                    Base64.Encoder base64 = Base64.getEncoder();
                    String username = RandomCodeUtil.randomIncode();
                    String phone = RandomCodeUtil.randomPhone();
                    user.setUsername(username);
                    user.setPassword(base64.encodeToString(username.getBytes()));
                    user.setPhone(phone);
                    userService.insert(user);
                }
            });
        }
        return "success";
    }


    @PostMapping("/insertBatch")
    @ResponseBody
    public String insertBatch(User user) {
        for (int i = 0; i < 1; i++) {
            Base64.Encoder base64 = Base64.getEncoder();
            String username = RandomCodeUtil.randomIncode();
            String phone = RandomCodeUtil.randomPhone();
            user.setUsername(username);
            user.setPassword(base64.encodeToString(username.getBytes()));
            user.setPhone(phone);
            userService.insert(user);
        }
        return "success";
    }

    @RequestMapping("/redis")
    @ResponseBody
    public String redisOperate() {
        String key = RandomCodeUtil.randomIncode();
        //存入string
        RedisUtil.set(key, key);
        //删除所有的key
        long l = RedisUtil.deleteAll("*");
        System.out.println(l);
        redisTemplate.opsForHash().put("0", "1", "25789");
        redisTemplate.opsForHash().put("0", "2", "2342");
        redisTemplate.opsForHash().put("1", "3", "2342");

        System.out.println(redisTemplate.opsForHash().get("0", "1"));
        System.out.println(redisTemplate.opsForHash().get("1", "3"));

        return "success";
    }

}
