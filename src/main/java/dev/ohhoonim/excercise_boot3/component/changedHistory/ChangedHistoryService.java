package dev.ohhoonim.excercise_boot3.component.changedHistory;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.ohhoonim.excercise_boot3.component.changedHistory.ChangedHistory.Entity;
import dev.ohhoonim.excercise_boot3.component.changedHistory.ChangedHistory.SearchCondition;
import dev.ohhoonim.excercise_boot3.component.changedHistory.infra.ChangedHistoryPort;

@Service
public class ChangedHistoryService implements ChangedHistory.Entity.Service {

    private final ChangedHistoryPort port;

    public ChangedHistoryService (ChangedHistoryPort port) {
        this.port = port;
    }

    @Override
    public List<Entity> histories(SearchCondition condition) {
        return port.histories(condition);
    }

    @Override
    @Transactional
    public void addHistory(Entity changedHistory) {
        port.recording(changedHistory);
    }


}
