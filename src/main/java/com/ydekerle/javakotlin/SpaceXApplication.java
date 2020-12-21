package com.ydekerle.javakotlin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SpaceXConfiguration.class)
@EnableConfigurationProperties
public class SpaceXApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceXApplication.class, args);
	}

}
