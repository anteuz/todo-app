package com.darkchitect.springboot.web.springbootfirstapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.darkchitect.springboot.web"})
public class SpringBootFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstApplication.class, args);
	}
}
