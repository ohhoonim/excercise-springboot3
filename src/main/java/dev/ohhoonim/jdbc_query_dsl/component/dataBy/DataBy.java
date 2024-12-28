package dev.ohhoonim.jdbc_query_dsl.component.dataBy;

import java.time.LocalDateTime;
import java.util.UUID;

public record DataBy(
    UUID createdBy,
    LocalDateTime createdDate,
    UUID lastModifiedBy,
    LocalDateTime lastModifiedDate
) {
    
}
