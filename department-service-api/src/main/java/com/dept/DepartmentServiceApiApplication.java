package com.dept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({ "com.dept" })
public class DepartmentServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentServiceApiApplication.class, args);
		System.out.println("####### DepartmentServiceApiApplication runing... ########");
	}

}
