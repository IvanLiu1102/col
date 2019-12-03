package com.col.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liu.min on 2018/11/12.
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/{msg}")
    public String returnMsg(@PathVariable String msg) {
        return "success micro service==============================" + msg;
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
