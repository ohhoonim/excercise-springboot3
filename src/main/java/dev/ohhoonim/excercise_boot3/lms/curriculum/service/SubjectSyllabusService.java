package dev.ohhoonim.excercise_boot3.lms.curriculum.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum;
import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum.SubjectSyllabus;
import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum.Syllabus;
import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum.SubjectSyllabus.Usecase;

@Service
public final class SubjectSyllabusService implements Curriculum.SubjectSyllabus.Usecase {

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
