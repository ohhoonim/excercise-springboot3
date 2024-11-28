package dev.ohhoonim.jdbc_query_dsl.component.changedHistory;

import java.time.LocalDate;
import java.util.UUID;

import dev.ohhoonim.jdbc_query_dsl.component.user.User;
import dev.ohhoonim.jdbc_query_dsl.domain.courses.Course.Round;

public sealed interface ChangedHistory {

    public static final String CourseClassify = "course";

    public record Condition (
        String classify,
        UUID recordId
    ) implements ChangedHistory{}

    public record Course(
            String classify,
            UUID recordId,
            String oldContents,
            String newContents,
            LocalDate createDate,
            User.Writer changeUser) implements ChangedHistory {

        public Course(UUID recordId, Round.Command oldRound,
                Round.Query newRound,
                User.Writer user) {
            this("course",
                    UUID.randomUUID(),
                    oldRound.toString(),
                    newRound.toString(),
                    LocalDate.now(),
                    user);
        }
    }

}
