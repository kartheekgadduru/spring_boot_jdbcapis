package com.springboot.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(MainApplication.class, args);// auto configuration 
		System.out.println("Main application spring boot application");
	
	
		System.out.println(context.getBeanDefinitionCount());
		for(String name : context.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}
