package dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model;

import java.util.List;
import java.util.Optional;

import dev.ohhoonim.jdbc_query_dsl.component.user.User.Professor;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Lecture;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Subject;

public interface SubjectQueryUsecase {

    public Optional<Professor> professor(Subject.Query subject); 
    
    public List<Lecture> lectures(Subject.Condition subject);
}
