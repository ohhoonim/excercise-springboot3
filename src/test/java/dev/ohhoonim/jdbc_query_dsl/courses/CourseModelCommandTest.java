package dev.ohhoonim.jdbc_query_dsl.courses;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import dev.ohhoonim.jdbc_query_dsl.domain.courses.CourseQueryUsecase;
import dev.ohhoonim.jdbc_query_dsl.domain.courses.CourseRepository;

public class CourseModelCommandTest {
    
    @InjectMocks
    CourseQueryUsecase course;

    @Mock
    CourseRepository repository;


    // TODO command는 별도 usecase 로 분리 
    public void courseUsecaseDefineCommand() {
        // 신규설계

        // 차수추가

        // 수정

        // 삭제

    }
}
