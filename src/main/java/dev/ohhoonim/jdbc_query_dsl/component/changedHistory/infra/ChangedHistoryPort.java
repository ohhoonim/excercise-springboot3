package dev.ohhoonim.jdbc_query_dsl.component.changedHistory.infra;

import java.util.List;

import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory.Entity;
import dev.ohhoonim.jdbc_query_dsl.component.changedHistory.ChangedHistory.SearchCondition;

public interface ChangedHistoryPort {

    List<Entity> histories(SearchCondition condition);

    void recording(Entity changedHistory);

}
