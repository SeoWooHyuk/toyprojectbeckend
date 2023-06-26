package com.springboot.beckend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@SpringBootApplication
public class ReststudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReststudyApplication.class, args);
	}

	@Bean
	MappingJackson2JsonView jsonView()
	{
		return new MappingJackson2JsonView();
	}

}
