package dev.ohhoonim.jdbc_query_dsl.lms.courses;

import java.util.List;
import java.util.Optional;

import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.ClassManager;


public interface CourseQueryUsecase {

    public List<Subject.ByCourse> subjects(Course.Round query) ;

    public List<Course.Round.Query> findCourses(Course.Condition condition);

    public Optional<ClassManager> manager(Course.Round.Query courseRound); 

    public List<ChangedHistory.Query> changedHistory(Course.Round.Query courseRound) ;
}
