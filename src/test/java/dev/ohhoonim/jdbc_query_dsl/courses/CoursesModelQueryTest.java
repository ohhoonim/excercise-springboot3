package dev.ohhoonim.jdbc_query_dsl.courses;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory;
import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistoryRepository;
import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory.Classify;
import dev.ohhoonim.jdbc_query_dsl.component.user.User;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.ClassManager;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Course;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.CourseQueryService;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.CourseRepository;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Subject;
import dev.ohhoonim.jdbc_query_dsl.component.user.UserRepository;

@ExtendWith(MockitoExtension.class)
public class CoursesModelQueryTest {

    @InjectMocks
    CourseQueryService course;

    @Mock
    CourseRepository courseRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    ChangedHistoryRepository changedHistoryRepository;

    @Test
    @DisplayName("1 학습과정 목록 조회")
    public void courses() {
        // given
        var condition = new Course.Condition("스프링부트", UUID.randomUUID(), null);
        // when
        var courseRound = List.of(
                new Course.Round.Query(UUID.randomUUID(), "spring boot regular course", 1, null, null, null, null, true,
                        null),
                new Course.Round.Query(UUID.randomUUID(), "nextjs special", 2, null, null, null, null, true, null),
                new Course.Round.Query(UUID.randomUUID(), "vuejs 3 enterance", 1, null, null, null, null, true, null));
        when(courseRepository.findCourses(any())).thenReturn(courseRound);

        // then
        List<Course.Round.Query> courses = course.findCourses(condition);

        assertThat(courses.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("1.2 매니저 연락처 조회")
    public void manager() {
        // given
        Course.Round.Query courseRound = new Course.Round.Query(UUID.randomUUID(), 1);

        // when
        var classManagerId = UUID.randomUUID();
        when(courseRepository.findCourseRound(any()))
                .thenReturn(Optional
                        .of(new Course.Round.Query(null, null, null, classManagerId, null, null, null, null, null)));

        when(userRepository.findUser(any(), any()))
                .thenReturn(Optional.of(new User.ClassManager(null, "matthew", null, null)));
        // then
        // 과정 목록 조회시 클래스 매니저 정보를 담아보낼 필요가 없음
        Optional<ClassManager> classManager = course.manager(courseRound);
        assertThat(classManager.get().name()).isEqualTo("matthew");
    }

    @Test
    @DisplayName("1.3 변경이력 조회")
    public void changedHistory() {
        // given
        var courseRound = new Course.Round.Query(UUID.randomUUID(), 1);

        // when
        var results = List.of(
                new ChangedHistory.Query(Classify.COURSE, null, null, null, null, null),
                new ChangedHistory.Query(Classify.COURSE, null, null, null, null, null));
        when(changedHistoryRepository.histories(any())).thenReturn(results);

        // then
        List<ChangedHistory.Query> history = course.changedHistory(courseRound);

        assertThat(history.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("2 과정 선택 후 과목 조회")
    public void subjects() {
        // given
        Course.Round courseQuery = new Course.Round.Query(
                UUID.randomUUID(),
                "2024년 하반기 스프링",
                3,
                null, null, null, null, true, null);

        // when
        var courseId = UUID.randomUUID();
        var professorId = UUID.randomUUID();
        List<Subject.ByCourse> stubSubjects = List.of(
                new Subject.ByCourse(courseId, UUID.randomUUID(), "title1", professorId),
                new Subject.ByCourse(courseId, UUID.randomUUID(), "title2", professorId),
                new Subject.ByCourse(courseId, UUID.randomUUID(), "title3", professorId));
        when(courseRepository.subjectsByCourseRound(any())).thenReturn(stubSubjects);

        // then
        List<Subject.ByCourse> resultSubjects = course.subjects(courseQuery);

        verify(courseRepository, times(1)).subjectsByCourseRound(any());
        assertThat(resultSubjects.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("2.1 대표교수 조회")
    public void professor() {
        // 대표교수는 과목별 임
       // 과목조회 -> 대표교수 정보 가져오기 
       // 과목에서 처리해야함 
    }

    public void courseUsecaseDefineQuery() {
        // 1 학습과정 목록 조회
        courses();
        // 1.2 매니저 연락처 조회
        manager();
        // 1.3 변경이력 조회
        changedHistory();
        // 2 과정 선택 후 과목 조회
        subjects();
        // 2.1 대표교수 조회
        professor();

        // 2.2 강의계획서 조회

    }

}
