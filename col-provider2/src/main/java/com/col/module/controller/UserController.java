package com.col.module.controller;

import com.col.common.util.RandomCodeUtil;
import com.col.module.bean.User;
import com.col.module.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Base64;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liu.min on 2018/11/30.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    private ExecutorService executorService = Executors.newFixedThreadPool(100);

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "success1";
    }

    @PostMapping("/insert")
    @ResponseBody
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
}
