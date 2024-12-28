package dev.ohhoonim.jdbc_query_dsl.courses;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;


// @ComponentScan(basePackages = { "dev.ohhoonim.jdbc_query_dsl.lms.courses",
//         "dev.ohhoonim.jdbc_query_dsl.configuration",
//         "dev.ohhoonim.jdbc_query_dsl.component" })
// @WebMvcTest(controllers = { CourseApi.class })
public class CoursesIntegrationTest {

    @Autowired
    MockMvcTester mockMvcTester;

    @Test
    public void standardResponseObjectTest() throws Exception {
        mockMvcTester.get().uri("/courses/cb5f4a88-95c4-4d38-8d1f-3617e1414317/subjects")
                .contentType(MediaType.APPLICATION_JSON)
                .assertThat().apply(print())
                    .hasStatus2xxSuccessful()
                    .bodyJson().hasPath("data");
    }

    private void randomUUID() {
        System.out.println(UUID.randomUUID());
    }

}
