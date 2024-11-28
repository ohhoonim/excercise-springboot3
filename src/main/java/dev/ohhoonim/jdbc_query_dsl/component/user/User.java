package dev.ohhoonim.jdbc_query_dsl.component.user;

import java.util.UUID;

public sealed interface User {

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

}
