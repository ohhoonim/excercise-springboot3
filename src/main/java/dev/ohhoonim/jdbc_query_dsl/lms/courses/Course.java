package dev.ohhoonim.jdbc_query_dsl.lms.courses;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory;

public sealed interface Course {
    public record Condition(
            String title,
            UUID classManagerId,
            Boolean isReservable) implements Course {
    }

    public sealed interface Round {
        public record Command(
                UUID courseRoundId,
                String title,
                Integer round) implements Round {
            public Command(UUID courseRoundId, Integer round) {
                this (courseRoundId, null, round);
            }
        }

        // note : courseRoundId와 round 는 복합키임
        public record Query(
                UUID courseRoundId,
                String title,
                Integer round,
                UUID classManagerId,
                LocalDate start,
                LocalDate end,
                Set<Target> targets,
                Boolean isReservable,
                ChangedHistory.Query historyInfo) implements Round {
            public Query {
                if (isReservable == null) {
                    isReservable = false;
                }
            } 
            public Query(UUID courseRoundId, Integer round) {
                this (courseRoundId, null, round, null,null,null,null,null,null);
            }
        }
    }
}
