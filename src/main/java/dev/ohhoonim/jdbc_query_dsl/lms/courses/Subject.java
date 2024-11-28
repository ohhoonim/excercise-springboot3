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
}