package dev.ohhoonim.jdbc_query_dsl.lms.courses;

import java.util.UUID;

import dev.ohhoonim.jdbc_query_dsl.component.masterCode.MasterCode;
import dev.ohhoonim.jdbc_query_dsl.component.user.User;

public sealed interface Lecture {
    public UUID lectureId();

    public record Condition(
        UUID subjectId,
        UUID lectureId
    ) implements Lecture {
    }

    public record Command(
            UUID lectureId,
            Integer round,
            String title,
            LectureMethod lectureMethod,
            Integer timeOfHour,
            String content,
            Boolean isCompleted,
            UUID professorId,
            UUID assistantId) implements Lecture {
    }

    public record Query(
            UUID lectureId,
            Integer round,
            String title,
            LectureMethod lectureMethod,
            Integer timeOfHour,
            String content,
            Boolean isCompleted,
            User.Professor professorId,
            User.Assistant assistantId
    ) implements Lecture {
    }

    public enum LectureMethod implements MasterCode {
        Online("online", "online"),
        Offline("offline", "offline"),
        Both("both", "both");

        private final String masterCode;
        private final String langCode;

        private LectureMethod(String masterCode, String langCode) {
            this.masterCode = masterCode;
            this.langCode = langCode;
        }

        @Override
        public String groupCode() {
            return "Lecture-Method";
        }

        @Override
        public String masterCode() {
            return masterCode;
        }

        @Override
        public String langCode() {
            return langCode;
        }
    }
}
