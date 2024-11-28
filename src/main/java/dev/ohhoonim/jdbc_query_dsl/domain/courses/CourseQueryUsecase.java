package dev.ohhoonim.jdbc_query_dsl.domain.courses;

import java.util.List;
import java.util.Optional;

import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.ClassManager;


public interface CourseQueryUsecase {

    public List<Subject.ByCourse> subjects(Course.Round query) ;

    public List<Course.Round.Query> findCourses(Course.Condition condition);

    public Optional<ClassManager> manager(Course.Round.Query courseRound); 

    public List<ChangedHistory.Course> changedHistory(Course.Round.Query courseRound) ;
}
