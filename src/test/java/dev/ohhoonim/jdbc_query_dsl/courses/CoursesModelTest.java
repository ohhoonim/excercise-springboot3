package dev.ohhoonim.jdbc_query_dsl.courses;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CoursesModelTest {

    // @InjectMocks
    // CourseService course;

    // @Mock
    // ChangedHistory.Usecase changedHistoryService;

    @Test
    @DisplayName("1 학습과정 목록 조회")
    public void courses() {
    }

    @Test
    @DisplayName("1.2 매니저 연락처 조회")
    public void manager() {
    }

    @Test
    @DisplayName("1.3 변경이력 조회")
    public void changedHistory() {
    }

    @Test
    @DisplayName("2 과정 선택 후 과목 조회")
    public void subjects() {
    }

    @Test
    @DisplayName("2.1 대표교수 조회")
    public void professor() {
    }

    @Test
    @DisplayName("2.2 강의계획서 목록 조회")
    public void syllabuses() {
    }

    @Test
    @DisplayName("2.3 강의계획서 상세 조회")
    public void syllabus() {

    }

    public void courseUsecaseDefineQuery() {
        // 1 학습과정 목록 조회
        courses();
        // 1.2 매니저 연락처 조회
        manager();
        // 1.3 변경이력 조회
        changedHistory();
        // 2 과정 선택 후 과목 조회
        subjects();
        // 2.1 대표교수 조회
        professor();
        // 2.2 강의계획서 목록 조회
        syllabuses();
        // 2.3 강의계획서 상세 조회
        syllabus();
    }

}
