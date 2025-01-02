package dev.ohhoonim.excercise_boot3.lms.curriculum;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.ohhoonim.excercise_boot3.lms.curriculum.ModelCurriculum.Subject;
import dev.ohhoonim.excercise_boot3.lms.curriculum.ModelCurriculum.SubjectCondition;

@Service
public final class SubjectService implements ModelCurriculum.Subject.Usecase {

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
