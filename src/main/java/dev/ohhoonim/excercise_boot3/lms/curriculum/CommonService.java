package dev.ohhoonim.excercise_boot3.lms.curriculum;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.ohhoonim.excercise_boot3.component.user.User.Assistant;
import dev.ohhoonim.excercise_boot3.component.user.User.ClassManager;
import dev.ohhoonim.excercise_boot3.component.user.User.Professor;

@Service
public final class CommonService implements ModelCurriculum.CommonUsecase {

    @Override
    public ClassManager manager(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'manager'");
    }

    @Override
    public Professor professor(UUID userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'professor'");
    }

    @Override
    public Assistant assistant(UUID uerId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'assistant'");
    }

}
