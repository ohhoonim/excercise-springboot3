package dev.ohhoonim.jdbc_query_dsl.lms.curriculum;

import org.springframework.stereotype.Service;

import dev.ohhoonim.jdbc_query_dsl.lms.curriculum.ModelCurriculum.Lecture;

@Service
public final class LectureService implements ModelCurriculum.Lecture.Usecase{

    @Override
    public Lecture modify(Lecture lecture) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modify'");
    }

}
