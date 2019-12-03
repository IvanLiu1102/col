package com.col;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ColConfigClientApplication {

    @Value("${url}")
    private String datUrl;
    @RequestMapping(value = "/hi")
    @ResponseBody
    public String hi(){
        return datUrl;
    }


    public static void main(String[] args) {
        SpringApplication.run(ColConfigClientApplication.class, args);
    }

}
