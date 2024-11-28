package dev.ohhoonim.jdbc_query_dsl.component.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, UUID> {

    <T> Optional<T> findUser(UUID classManagerId, Class<T> userType);
    
}
