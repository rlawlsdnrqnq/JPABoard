package com.example.practice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@EnableJpaAuditing
@SpringBootApplication
public class Practice2Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice2Application.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter () {
		return new HiddenHttpMethodFilter();
	}


}
