package dev.ohhoonim.excercise_boot3;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class ExcerciseSpringboot3ApplicationTest {

	@Test
	void contextLoads() {
		var modules = ApplicationModules.of(ExcerciseSpringboot3Application.class);
		modules.verify();
	}

	ApplicationModules modules = ApplicationModules.of(ExcerciseSpringboot3Application.class);

	@Test
	public void writeDocumentationSnippets() {
		new Documenter(modules)
			.writeModulesAsPlantUml()
			.writeIndividualModulesAsPlantUml();
	}

}
