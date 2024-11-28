package dev.ohhoonim.jdbc_query_dsl.domain.courses;

public class CourseNotFound extends RuntimeException {
    public CourseNotFound(String message) {
        super(message);
    }
}
