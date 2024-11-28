package dev.ohhoonim.jdbc_query_dsl.component.changedHistory;

import java.time.LocalDate;
import java.util.UUID;

import dev.ohhoonim.jdbc_query_dsl.component.user.User;

public sealed interface ChangedHistory {

    public enum Classify {
        COURSE
    }

    public record Condition(
            Classify classify,
            UUID recordId) implements ChangedHistory {
    }

    public record Query(
            Classify classify,
            UUID recordId,
            String oldContents,
            String newContents,
            LocalDate createDate,
            User.Writer changeUser) implements ChangedHistory {
    }

    public record Command(
            Classify classify,
            UUID recordId) implements ChangedHistory {
    }

}
