package com.SetEnvironment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class User {
	@Bean
	public String Msg() {
		return "Hello World";
	}
}
