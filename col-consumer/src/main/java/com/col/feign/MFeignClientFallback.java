package com.col.feign;

import org.springframework.stereotype.Component;

/**
 * Created by liu.min on 2018/11/12.
 */
@Component
public class MFeignClientFallback implements MFeignClient{
    @Override
    public String sayMicrServiceoHello(String msg) {
        return "test fallback:" + msg;
    }

    @Override
    public String hello() {
        return "hello fallback ";
    }

    @Override
    public String inserUser() {
        return null;
    }
}
