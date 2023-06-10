package com.SpringBoot.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		
		ApplicationContext con = SpringApplication.run(Application.class,args);
		
		for(String a : con.getBeanDefinitionNames()) {
			System.out.println(a);
		}
	
	
	
	}

}
