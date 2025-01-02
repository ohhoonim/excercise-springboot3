package dev.ohhoonim.excercise_boot3.lms.curriculum.service;

import org.springframework.stereotype.Service;

import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum;
import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum.Lecture;
import dev.ohhoonim.excercise_boot3.lms.curriculum.Curriculum.Lecture.Usecase;

@Service
public final class LectureService implements Curriculum.Lecture.Usecase{

    @Override
    public Lecture modify(Lecture lecture) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

}
