package dev.ohhoonim.jdbc_query_dsl.component.user;

import java.util.UUID;

import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.ApplicationModule.Type;

@ApplicationModule(type=Type.OPEN)
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
