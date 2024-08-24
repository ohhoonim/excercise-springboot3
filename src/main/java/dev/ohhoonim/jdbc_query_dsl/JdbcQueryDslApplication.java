package dev.ohhoonim.jdbc_query_dsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JdbcQueryDslApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcQueryDslApplication.class, args);
	}

}
