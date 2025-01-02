package dev.ohhoonim.excercise_boot3.lms;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

// @ComponentScan(basePackages = { "dev.ohhoonim.excercise_boot3.lms.courses",
//         "dev.ohhoonim.excercise_boot3.configuration",
//         "dev.ohhoonim.excercise_boot3.component" })
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
}
