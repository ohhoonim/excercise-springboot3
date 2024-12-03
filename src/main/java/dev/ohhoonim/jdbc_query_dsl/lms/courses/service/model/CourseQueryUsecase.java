package dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model;

import java.util.List;
import java.util.Optional;

import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.ClassManager;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.Professor;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Course;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Lecture;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Subject;


public interface CourseQueryUsecase {

    public List<Subject.ByCourse> subjects(Course.Round query) ;

    public List<Course.Round.Query> findCourses(Course.Condition condition);

    public Optional<ClassManager> manager(Course.Round.Query courseRound); 

    public List<ChangedHistory.Query> changedHistory(Course.Round.Query courseRound) ;

    public Optional<Professor> professor(Subject.Query subject); 
    
    public List<Lecture> lectures(Subject.Condition subject);

    public Optional<Lecture> findLecture(Lecture.Condition condition); 


}
