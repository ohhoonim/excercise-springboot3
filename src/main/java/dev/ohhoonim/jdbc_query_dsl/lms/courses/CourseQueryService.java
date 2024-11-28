package dev.ohhoonim.jdbc_query_dsl.lms.courses;

import java.util.List;
import java.util.Optional;

import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory;
import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistoryRepository;
import dev.ohhoonim.jdbc_query_dsl.component.user.User;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.ClassManager;
import dev.ohhoonim.jdbc_query_dsl.configuration.Usecase;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Course.Round.Query;
import dev.ohhoonim.jdbc_query_dsl.component.user.UserRepository;
import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
public class CourseQueryService implements CourseQueryUsecase {

    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final ChangedHistoryRepository changedHistoryRepository;

    @Override
    public List<Subject.ByCourse> subjects(Course.Round courseRound) {
        return courseRepository.subjectsByCourseRound(courseRound);
    }

    @Override
    public List<Course.Round.Query> findCourses(Course.Condition condition) {
        return courseRepository.findCourses(condition);
    }

    @Override
    public Optional<ClassManager> manager(Course.Round.Query courseRound) {
        Optional<Course.Round.Query> course = courseRepository.findCourseRound(courseRound.courseRoundId());

        if (course.isEmpty()) {
            throw new CourseNotFound("해당과정을 찾을 수가 없습니다. ");
        }

        return userRepository.findUser(course.get().classManagerId(), User.ClassManager.class);
    }

    @Override
    public List<ChangedHistory.Query> changedHistory(Query courseRound) {
        var condition = new ChangedHistory
                .Condition(ChangedHistory.Classify.COURSE, courseRound.courseRoundId());

        return changedHistoryRepository.histories(condition);
    }


}
