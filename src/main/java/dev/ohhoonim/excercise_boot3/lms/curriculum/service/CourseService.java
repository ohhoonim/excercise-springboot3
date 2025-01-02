package dev.ohhoonim.excercise_boot3.lms.curriculum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum;
import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum.Course;
import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum.CourseCondition;
import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum.Course.Usecase;

@Service
public final class CourseService implements Curriculum.Course.Usecase {

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
