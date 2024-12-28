package dev.ohhoonim.jdbc_query_dsl.lms.curriculum;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.annotation.Id;

import dev.ohhoonim.jdbc_query_dsl.component.user.User;

public sealed interface ModelCurriculum {

    public record Course(
            @Id UUID courseId,
            String name,
            Integer round,
            String target,
            String content,
            UUID classManagerId,
            LocalDate startDate,
            LocalDate endDate,
            Boolean closed) implements ModelCurriculum {

        public interface Usecase {

            public Boolean isClosed(Course course);

            public Course newRound(Course latestCourse);

            public Course save(Course course);

            public List<Course> listCourse(CourseCondition courseCondition);
        }
    }

    public record CourseSubject(
            @Id UUID courseId,
            @Id UUID subjectSyllabusId) implements ModelCurriculum {

        public interface Usecase {

            public List<Subject> addSubject(CourseSubject courseSubject);

            public List<Subject> removeSubject(CourseSubject courseSubject);

            public List<Subject> subjects(UUID courseId);

            public List<Course> courses(UUID subjectId);
        }
    }

    public record Subject(
            @Id UUID subjectId,
            String title,
            String category) implements ModelCurriculum {

        public interface Usecase {

            public Subject save(Subject subject);

            public List<Subject> listSubject(SubjectCondition subjectCondition);
        }

    }

    public record SubjectSyllabus(
            @Id UUID subjectSyllabusId,
            UUID subjectId,
            UUID syllabusId) implements ModelCurriculum {
        public interface Usecase {

            public List<Syllabus> syllabues(UUID subjectId);

            public List<Syllabus> addSyllabus(UUID subjectId, UUID syllabusId);

            public List<Syllabus> removeSyllabus(UUID subjectSyllabusId);
        }
    }

    public record Syllabus(
            @Id UUID syllabusId,
            String title,
            Integer timeOfHour,
            String timeUnit,
            UUID professorId) implements ModelCurriculum {

        public interface Usecase {

            public Syllabus save(Syllabus syllabus);

            public Set<String> lecturesMethods();

            public List<Lecture> addLecture(Lecture lecture);

            public List<Lecture> removeLecture(Long lecture);

            public List<Lecture> lectures(UUID syllabusid);
        }
    }

    public record Lecture(
            @Id Long lectureId,
            UUID syllabusId,
            Integer round,
            String title,
            String lectureMethod,
            Integer timeOfHour,
            String content,
            Boolean isCompleted,
            UUID professorId,
            UUID assistantId) implements ModelCurriculum {

        public interface Usecase {

            public Lecture modify(Lecture lecture);

        }
    }

    public sealed interface CommonUsecase permits CommonService {

        public User.ClassManager manager(UUID userId);

        public User.Professor professor(UUID userId);

        public User.Assistant assistant(UUID uerId);
    }

    public record CourseCondition(
            UUID courseId,
            String name,
            Integer round,
            String target,
            UUID classManagerId,
            LocalDate startDate,
            LocalDate endDate,
            Boolean closed) {
    }

    public record SubjectCondition(
            UUID subjectId,
            String title,
            String category) {
    }
}
