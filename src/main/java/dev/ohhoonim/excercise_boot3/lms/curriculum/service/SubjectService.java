package dev.ohhoonim.excercise_boot3.lms.curriculum.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum;
import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum.Subject;
import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum.SubjectCondition;
import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum.Subject.Usecase;

@Service
public final class SubjectService implements Curriculum.Subject.Usecase {

    @Override
    public Subject save(Subject subject) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List<Subject> listSubject(SubjectCondition subjectCondition) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listSubject'");
    }

}
