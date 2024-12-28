package dev.ohhoonim.jdbc_query_dsl.lms.curriculum;

import java.util.UUID;

import org.springframework.stereotype.Service;

import dev.ohhoonim.jdbc_query_dsl.component.user.User.Assistant;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.ClassManager;
import dev.ohhoonim.jdbc_query_dsl.component.user.User.Professor;

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
