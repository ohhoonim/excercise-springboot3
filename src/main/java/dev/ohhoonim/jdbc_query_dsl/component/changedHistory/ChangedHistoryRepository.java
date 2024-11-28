package dev.ohhoonim.jdbc_query_dsl.component.changedHistory;

import java.util.List;

import org.springframework.data.repository.Repository;

import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory.Condition;
import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory.Course;

public interface ChangedHistoryRepository extends Repository {

    List<Course> histories(Condition condition);
    
}
