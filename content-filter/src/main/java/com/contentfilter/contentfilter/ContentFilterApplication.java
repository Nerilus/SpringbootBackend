package com.contentfilter.contentfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.contentfilter.contentfilter.repository")
@EntityScan("com.contentfilter.contentfilter.model")
@SpringBootApplication
public class ContentFilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentFilterApplication.class, args);
	}

}
