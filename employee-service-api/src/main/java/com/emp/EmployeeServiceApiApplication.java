package com.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({ "com.emp" })
public class EmployeeServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApiApplication.class, args);
		System.out.println("####### EmployeeServiceApiApplication runing... ########");
	}

}
