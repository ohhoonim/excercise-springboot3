package dev.ohhoonim.jdbc_query_dsl.lms.curriculum;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.ohhoonim.jdbc_query_dsl.lms.curriculum.ModelCurriculum.Syllabus;

@Service
public final class SubjectSyllabusService implements ModelCurriculum.SubjectSyllabus.Usecase {

    @Override
    public List<Syllabus> syllabues(UUID subjectId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'syllabues'");
    }

    @Override
    public List<Syllabus> addSyllabus(UUID subjectId, UUID syllabusId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addSyllabus'");
    }

    @Override
    public List<Syllabus> removeSyllabus(UUID subjectSyllabusId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeSyllabus'");
    }

}
