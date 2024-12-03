package dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import dev.ohhoonim.jdbc_query_dsl.lms.courses.Subject;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Subject.Query;

public interface SubjectQueryRepository extends Repository<Subject, UUID>{

    Optional<Query> findSubject(UUID subjectId);

}
