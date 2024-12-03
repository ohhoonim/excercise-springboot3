package dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import dev.ohhoonim.jdbc_query_dsl.lms.courses.Lecture;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Syllabus;

public interface SyllabusQueryRepository extends Repository<Syllabus, UUID> {

    List<Lecture> lecturesBySubject(UUID subjectId);

    Optional<Lecture> findLecture(UUID syllabusId);
    
}
