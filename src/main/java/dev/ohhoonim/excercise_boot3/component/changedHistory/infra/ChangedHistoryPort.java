package dev.ohhoonim.excercise_boot3.component.changedHistory.infra;

import java.util.List;

import dev.ohhoonim.excercise_boot3.component.changedHistory.ChangedHistory.Entity;
import dev.ohhoonim.excercise_boot3.component.changedHistory.ChangedHistory.SearchCondition;

public interface ChangedHistoryPort {

    List<Entity> histories(SearchCondition condition);

    void recording(Entity changedHistory);

}
