package dev.ohhoonim.jdbc_query_dsl.component.user;

import java.util.UUID;

public sealed interface User {
    UUID userId();
    String name();

    public record ClassManager(
        UUID userId,
        String name,
        String email,
        String phone
    ) implements User {
    }

    public record Writer (
        UUID userId,
        String name
    ) implements User {
    }

    public record Professor(
        UUID userId,
        String name,
        String email,
        String phone
    ) implements User {
    }
    public record Assistant(
        UUID userId,
        String name,
        String email,
        String phone
    ) implements User {
    }
}
