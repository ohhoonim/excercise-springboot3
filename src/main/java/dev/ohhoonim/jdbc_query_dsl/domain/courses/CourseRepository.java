package dev.ohhoonim.jdbc_query_dsl.domain.courses;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import dev.ohhoonim.jdbc_query_dsl.component.user.User.ClassManager;
import dev.ohhoonim.jdbc_query_dsl.domain.courses.Course.Condition;
import dev.ohhoonim.jdbc_query_dsl.domain.courses.Course.Round;

public interface CourseRepository extends Repository <Course.Round, UUID>{

    List<Subject.ByCourse> subjectsByCourseRound(Course.Round courseRound);

    List<Round.Query> findCourses(Condition condition);

    ClassManager manager(Round courseRound);

    Optional<Round.Query> findCourseRound(UUID courseRoundId);

}
