package com.col.controller;

import com.col.feign.MFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liu.min on 2018/11/12.
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Autowired
    private MFeignClient feignClient;

    @RequestMapping("/test/{msg}")
    @HystrixCommand(fallbackMethod = "hiErr")
    public String sayMicroServiceHello(@PathVariable String msg){
        String result = feignClient.sayMicrServiceoHello(msg);
        return result;
    }

    // 当服务中心挂掉时，断路器要跑的方法
    public String hiErr(@RequestParam String name){
        return "sorry," + name + ",have a erro222r";
    }

    @RequestMapping("/hello")
    @HystrixCommand
    public String hello(){
        String result = feignClient.hello();
        return result;
    }


    @RequestMapping("/insert")
    @HystrixCommand
    public String insert(){
        String result = feignClient.inserUser();
        return result;
    }
}
