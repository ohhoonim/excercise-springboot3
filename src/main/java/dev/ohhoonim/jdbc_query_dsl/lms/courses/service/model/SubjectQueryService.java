package dev.ohhoonim.jdbc_query_dsl.lms.courses.service.model;

import java.util.List;
import java.util.Optional;

import dev.ohhoonim.jdbc_query_dsl.component.user.User;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.Professor;
import dev.ohhoonim.jdbc_query_dsl.component.user.UserRepository;
import dev.ohhoonim.jdbc_query_dsl.configuration.Usecase;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.CourseNotFound;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Lecture;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Subject;
import dev.ohhoonim.jdbc_query_dsl.lms.courses.Subject.Condition;
import lombok.RequiredArgsConstructor;

@Usecase
@RequiredArgsConstructor
public class SubjectQueryService implements SubjectQueryUsecase {

    private final SubjectQueryRepository repository;
    private final UserRepository userRepository;
    private final SyllabusQueryRepository syllabusRepository;

    public Optional<Professor> professor(Subject.Query subject) {
        Optional<Subject.Query> subjectResult = repository.findSubject(subject.subjectId());
        if (subjectResult.isEmpty()) {
            throw new CourseNotFound("과목을 찾을 수 없습니다."); 
        }
        return userRepository.findUser(subject.professorId(), User.Professor.class);
    }

    @Override
    public List<Lecture> lectures(Condition subject) {
        return syllabusRepository.lecturesBySubject(subject.subjectId());
    }
    
}
