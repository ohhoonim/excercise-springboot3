package dev.ohhoonim.excercise_boot3.component;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.ComponentScan;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import dev.ohhoonim.excercise_boot3.component.changedHistory.ChangedHistoryService;
import dev.ohhoonim.excercise_boot3.component.changedHistory.ChangedHistory.Classify;
import dev.ohhoonim.excercise_boot3.component.changedHistory.ChangedHistory.SearchCondition;
import dev.ohhoonim.excercise_boot3.component.dataBy.DataBy;

@ComponentScan(basePackages = {"dev.ohhoonim.excercise_boot3.configuration",
"dev.ohhoonim.excercise_boot3.component"})
@Testcontainers
@AutoConfigureTestDatabase(
    replace = AutoConfigureTestDatabase.Replace.NONE
)
@SpringBootTest
public class ChangedHistoryIntegrationTest {

    @Container
    @ServiceConnection
    private static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15.7");

    @Autowired
    ChangedHistoryService service;

    @Test
    public void addHistory() {
        var recordId = UUID.randomUUID(); 
        var referencedId = UUID.randomUUID(); 

        var dataBy = new DataBy(
            UUID.randomUUID(),
            LocalDateTime.now(),
            UUID.randomUUID(),
            LocalDateTime.now()
        );

        var changed = new ChangedHistory.Entity(
            recordId,
            Classify.COURSE,
            referencedId,
            "old contents", "new contents",
            dataBy
        );

        service.addHistory(changed);

        var list = service.histories(new SearchCondition(Classify.COURSE, referencedId));

        assertThat(list.size()).isEqualTo(1);
    }

}
