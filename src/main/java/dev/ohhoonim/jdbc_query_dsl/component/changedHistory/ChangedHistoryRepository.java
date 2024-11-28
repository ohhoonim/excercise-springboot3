package dev.ohhoonim.jdbc_query_dsl.component.changedHistory;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.Repository;

import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory.Condition;
import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory.Query;

public interface ChangedHistoryRepository extends Repository<ChangedHistory, UUID> {

    List<Query> histories(Condition condition);
    
}
