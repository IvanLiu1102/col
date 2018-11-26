package com.col.feign;

import com.col.feign.config.MFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liu.min on 2018/11/12.
 *
 */
//name是指要请求的服务名称。这里请求的是服务提供者
//fallback 是指请求失败，进入断路器的类，和使用ribbon是一样的。
//configuration 是feign的一些配置，例如编码器等。
@FeignClient(name = "col-provider", fallback = MFeignClientFallback.class, configuration = MFeignConfig.class)
public interface MFeignClient {

    // 这是被请求微服务的地址，也就是provider的地址
    @RequestMapping(value = "/index/{msg}")
    String sayMicrServiceoHello(@PathVariable("msg") String msg);

    @RequestMapping(value = "/index/hello")
    String hello();
}
