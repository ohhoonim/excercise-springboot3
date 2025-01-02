package dev.ohhoonim.excercise_boot3.lms.curriculum;

import org.springframework.stereotype.Service;

import dev.ohhoonim.excercise_boot3.lms.curriculum.ModelCurriculum.Lecture;

@Service
public final class LectureService implements ModelCurriculum.Lecture.Usecase{

    @Override
    public Lecture modify(Lecture lecture) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

}
