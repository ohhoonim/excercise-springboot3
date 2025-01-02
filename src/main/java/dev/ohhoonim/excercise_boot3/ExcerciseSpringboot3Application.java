package dev.ohhoonim.excercise_boot3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableCaching
public class ExcerciseSpringboot3Application {

	public static void main(String[] args) {
		SpringApplication.run(ExcerciseSpringboot3Application.class, args);
	}

}
