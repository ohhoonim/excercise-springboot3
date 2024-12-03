package dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model;

import java.util.Optional;

import dev.ohhoonim.jdbc_query_dsl.lms.courses.Lecture;

public interface SyllabusQueryUsecase {

    public Optional<Lecture> findLecture(Lecture.Condition condition); 
    
}
