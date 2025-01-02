package dev.ohhoonim.excercise_boot3.component.user.delivery;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.ohhoonim.excercise_boot3.component.user.User;
import dev.ohhoonim.excercise_boot3.component.user.UserRepository;
import dev.ohhoonim.excercise_boot3.component.user.User.Usecase;

@Service
public class UserService implements Usecase{

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UUID userId() {
        return UUID.randomUUID();
    }

    @Override
    public String name() {
        // TODO 랜덤으로 이름을 만들어주는 로직 추가 
        return null;
    }

    @Override
    public <T extends User> Optional<T> findByUserId(UUID userId, Class<T> clazz) {
        return repository.findByUserId(userId, clazz);
    }
    
}
