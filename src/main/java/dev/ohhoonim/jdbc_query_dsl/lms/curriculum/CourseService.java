package dev.ohhoonim.jdbc_query_dsl.lms.curriculum;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.ohhoonim.jdbc_query_dsl.lms.curriculum.ModelCurriculum.Course;
import dev.ohhoonim.jdbc_query_dsl.lms.curriculum.ModelCurriculum.CourseCondition;
import dev.ohhoonim.jdbc_query_dsl.lms.curriculum.ModelCurriculum.Course.Usecase;

@Service
public final class CourseService implements ModelCurriculum.Course.Usecase {

    @Override
    public Boolean isClosed(Course course) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isClosed'");
    }

    @Override
    public Course newRound(Course latestCourse) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'newRound'");
    }

    @Override
    public Course save(Course course) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Course> listCourse(CourseCondition courseCondition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listCourse'");
    }

}
