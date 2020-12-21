package com.ydekerle.javakotlin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SpaceXConfiguration.class)
public class SpaceXApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceXApplication.class, args);
	}

}
