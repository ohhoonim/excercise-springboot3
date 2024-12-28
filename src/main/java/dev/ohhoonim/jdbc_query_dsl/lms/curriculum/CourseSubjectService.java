package dev.ohhoonim.jdbc_query_dsl.lms.curriculum;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.ohhoonim.jdbc_query_dsl.lms.curriculum.ModelCurriculum.Course;
import dev.ohhoonim.jdbc_query_dsl.lms.curriculum.ModelCurriculum.CourseSubject;
import dev.ohhoonim.jdbc_query_dsl.lms.curriculum.ModelCurriculum.Subject;

@Service
public final class CourseSubjectService implements ModelCurriculum.CourseSubject.Usecase {

    @Override
    public List<Subject> addSubject(CourseSubject courseSubject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSubject'");
    }

    @Override
    public List<Subject> removeSubject(CourseSubject courseSubject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeSubject'");
    }

    @Override
    public List<Subject> subjects(UUID courseId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subjects'");
    }

    @Override
    public List<Course> courses(UUID subjectId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'courses'");
    }

}
