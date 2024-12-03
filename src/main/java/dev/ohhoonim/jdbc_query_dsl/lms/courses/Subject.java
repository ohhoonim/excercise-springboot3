package dev.ohhoonim.jdbc_query_dsl.lms.courses;

import java.util.UUID;

public sealed interface Subject {

    public record ByCourse (
        UUID courseId,
        UUID subjectId,
        String subjectTitle,
        UUID professorId 
    ) implements Subject {

    }
    public record Condition (
        UUID subjectId
    ) implements Subject {
    }

    public record Query (
        UUID subjectId,
        String subjectTitle,
        UUID professorId 
    ) implements Subject {}

}
