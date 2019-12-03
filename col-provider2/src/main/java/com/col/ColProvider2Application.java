package com.col;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ColProvider2Application {

	public static void main(String[] args) {
		SpringApplication.run(ColProvider2Application.class, args);
	}

}

