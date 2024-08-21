package dev.ohhoonim.jdbc_query_dsl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class JdbcQueryDslApplicationTests {

	@Test
	void contextLoads() {
		var modules = ApplicationModules.of(JdbcQueryDslApplication.class);
		for (var m : modules) {
			System.out.println(m.getName() + " : " + m.getBasePackage());
		}
		modules.verify();
	}

}
