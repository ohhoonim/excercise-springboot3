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
import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory.Classify;
import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistoryRepository;
import dev.ohhoonim.jdbc_query_dsl.component.user.User;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.ClassManager;
import dev.ohhoonim.jdbc_query_dsl.component.user.UserRepository;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Course;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Lecture;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Subject;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Syllabus;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model.CourseQueryRepository;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model.CourseQueryService;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model.SubjectQueryRepository;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model.SubjectQueryService;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model.SyllabusQueryRepository;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model.SyllabusQueryService;

@ExtendWith(MockitoExtension.class)
public class CoursesModelQueryTest {

    @InjectMocks
    CourseQueryService course;

    @Mock
    CourseQueryRepository courseRepository;

    @Mock
    UserRepository userRepository;

    @Mock
    ChangedHistoryRepository changedHistoryRepository;

    @InjectMocks
    SubjectQueryService subject;

    @Mock
    SubjectQueryRepository subjectRepository;

    @InjectMocks
    SyllabusQueryService syllabus;

    @Mock
    SyllabusQueryRepository syllabusRepository;

    @Test
    @DisplayName("1 학습과정 목록 조회")
    public void courses() {
        // given
        var condition = new Course.Condition("스프링부트", UUID.randomUUID(), null);
        // when
        var courseRound = List.of(
                new Course.Round.Query(UUID.randomUUID(), "spring boot regular course", 1, null, null,
                        null, null, true,
                        null),
                new Course.Round.Query(UUID.randomUUID(), "nextjs special", 2, null, null, null, null,
                        true, null),
                new Course.Round.Query(UUID.randomUUID(), "vuejs 3 enterance", 1, null, null, null,
                        null, true, null));
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
                        .of(new Course.Round.Query(null, null, null, classManagerId, null, null,
                                null, null, null)));

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
        // given
        UUID professorId = UUID.randomUUID();
        var math = new Subject.Query(UUID.randomUUID(), "기초수학", professorId);

        // when

        when(subjectRepository.findSubject(any())).thenReturn(Optional.of(
                new Subject.Query(null, null, null)));

        var professor = new User.Professor(
                professorId, "ohhoonim", "ohhoonim@gmail.com", "010-0000-0000");
        when(userRepository.findUser(any(), any())).thenReturn(Optional.of(professor));

        // then
        Optional<User.Professor> professorInfo = subject.professor(math);
        assertThat(professorInfo.isPresent()).isTrue();
        assertThat(professorInfo.get().name()).isEqualTo("ohhoonim");
    }

    @Test
    @DisplayName("2.2 강의계획서 목록 조회")
    public void syllabuses() {
        // given
        UUID subjectId = UUID.randomUUID();

        // when
        List<Lecture> resultLectures = List.of(
            new Lecture.Query(UUID.randomUUID(), null, null, null, null, null, null, null, null),
            new Lecture.Query(UUID.randomUUID(), null, null, null, null, null, null, null, null)
        );
        when(syllabusRepository.lecturesBySubject(any())).thenReturn(resultLectures);

        List<Lecture> lectures = subject.lectures(new Subject.Condition(subjectId));
        assertThat(lectures.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("2.3 강의계획서 상세 조회")
    public void syllabus() {

        // given
        var lectureId = UUID.randomUUID();
        Optional<Lecture> lectureParam = Optional.of(new Lecture.Condition(null, lectureId));
        // when
        when(syllabusRepository.findLecture(any())).thenReturn(lectureParam);
        // then 
        Optional<Lecture> resultLecture = syllabus.findLecture(new Lecture.Condition(null, lectureId));

        assertThat(resultLecture.get().lectureId()).isEqualTo(lectureParam.get().lectureId());
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
        // 2.2 강의계획서 목록 조회
        syllabuses();
        // 2.3 강의계획서 상세 조회 
        syllabus();
    }

}
