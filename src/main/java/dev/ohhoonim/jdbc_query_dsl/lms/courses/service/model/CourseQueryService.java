package dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model;

import java.util.List;
import java.util.Optional;

import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory;
import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistoryRepository;
import dev.ohhoonim.jdbc_query_dsl.component.user.User;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.ClassManager;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.Professor;
import dev.ohhoonim.jdbc_query_dsl.component.user.UserRepository;
import dev.ohhoonim.jdbc_query_dsl.configuration.Usecase;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Course;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Course.Round.Query;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.CourseNotFound;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Lecture;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Subject;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Subject.Condition;
import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
public class CourseQueryService implements CourseQueryUsecase {

    private final CourseQueryRepository courseRepository;
    private final UserRepository userRepository;
    private final ChangedHistoryRepository changedHistoryRepository;
    private final SubjectQueryRepository subjectRepository;
    private final SyllabusQueryRepository syllabusRepository;

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
        var condition = new ChangedHistory.Condition(ChangedHistory.Classify.COURSE, courseRound.courseRoundId());

        return changedHistoryRepository.histories(condition);
    }

    @Override
    public Optional<Lecture> findLecture(Lecture.Condition condition) {
        return syllabusRepository.findLecture(condition.lectureId());
    }

    @Override
    public Optional<Professor> professor(Subject.Query subject) {
        Optional<Subject.Query> subjectResult = subjectRepository.findSubject(subject.subjectId());
        if (subjectResult.isEmpty()) {
            throw new CourseNotFound("과목을 찾을 수 없습니다.");
        }
        return userRepository.findUser(subject.professorId(), User.Professor.class);
    }

    @Override
    public List<Lecture> lectures(Condition subject) {
        return syllabusRepository.lecturesBySubject(subject.subjectId());
    }
}
