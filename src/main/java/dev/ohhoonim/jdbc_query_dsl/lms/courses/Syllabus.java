package dev.ohhoonim.jdbc_query_dsl.lms.courses;

import java.util.List;
import java.util.UUID;

import dev.ohhoonim.jdbc_query_dsl.component.user.User;

public sealed interface Syllabus {

    public record Condition(
        UUID syllabusId,
        UUID professorId 
    ) implements Syllabus {
    }

    public record Query(
        UUID syllabusId,
        String title,
        Integer timeOfHour,
        String timeUnit,
        User.Professor professor,
        List<Lecture> lectures
    ) implements Syllabus {
    }

    public record Command(
        UUID syllabusId,
        String title,
        Integer timeOfHour,
        String timeUnit,
        UUID professorId
    ) implements Syllabus {
    }
}
