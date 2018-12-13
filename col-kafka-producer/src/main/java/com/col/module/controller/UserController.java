package com.col.module.controller;

import com.col.common.utils.RandomCodeUtil;
import com.col.common.utils.RedisUtil;
import com.col.module.bean.User;
import com.col.module.service.IUserService;
import io.swagger.annotations.Api;
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
import java.util.Date;
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

    @PostMapping("/insert")
    @ResponseBody
    @ApiOperation("插入用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "username", value = "用户编号", required = true, dataType = "String"),
        @ApiImplicitParam(name = "createTime", value = "创建时间", required = true, dataType = "Date")
    })
    public String insert(User user){
        Base64.Encoder base64 =Base64.getEncoder();
        String username = RandomCodeUtil.randomIncode();
        String phone = RandomCodeUtil.randomPhone();
        user.setUsername(username);
        user.setPassword(base64.encodeToString(username.getBytes()));
        user.setPhone(phone);
        userService.insert(user);
        return "success";
    }

    @RequestMapping("/redis")
    @ResponseBody
    public String redisOperate(){
        redisTemplate.opsForValue().set("key","value");
        System.out.println(redisTemplate.opsForValue().get("key"));
        return "success";
    }
}
