package com.freeSystems.RestaurantSystem.InventorySystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RestaurantSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantSystemApplication.class, args);
	}

}
