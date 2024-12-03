package dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model;

import java.util.Optional;

import dev.ohhoonim.jdbc_query_dsl.configuration.Usecase;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Lecture;
import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
public class SyllabusQueryService implements SyllabusQueryUsecase {


    private final SyllabusQueryRepository repository;

    public Optional<Lecture> findLecture(Lecture.Condition condition) {
        return repository.findLecture(condition.lectureId());
    }
    
}
