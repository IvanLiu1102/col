package com.col;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ColEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ColEurekaServerApplication.class, args);
	}
}
