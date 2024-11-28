package dev.ohhoonim.jdbc_query_dsl;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class JdbcQueryDslApplicationTests {

	@Test
	void contextLoads() {
		var modules = ApplicationModules.of(JdbcQueryDslApplication.class);
		modules.verify();
	}

	ApplicationModules modules = ApplicationModules.of(JdbcQueryDslApplication.class);

	@Test
	public void writeDocumentationSnippets() {
		new Documenter(modules)
			.writeModulesAsPlantUml()
			.writeIndividualModulesAsPlantUml();
	}

}
