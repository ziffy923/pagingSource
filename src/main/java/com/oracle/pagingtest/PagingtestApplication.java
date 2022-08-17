package com.oracle.pagingtest;

import java.util.Scanner;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PagingtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagingtestApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// registry.addMapping("/hello").allowedOrigins("http://localhost:9000/");
				// registry.addMapping("/hello").allowedOrigins("*");
				registry.addMapping("/**").allowedMethods("*");
			}
		};
	}

}
