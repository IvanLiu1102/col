package com.col.module;

import com.col.module.bean.User;
import com.col.module.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;

/**
 * Created by liu.min on 2018/11/30.
 */
@RestController
public class JTestController {



    @RequestMapping("/jtest")
    public String test(String message){

        System.out.println("==================" + message);
        return "success";
    }
}
