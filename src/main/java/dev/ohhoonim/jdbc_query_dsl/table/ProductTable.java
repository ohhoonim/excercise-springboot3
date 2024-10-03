package dev.ohhoonim.jdbc_query_dsl.table;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("product")
public record ProductTable (
    @Id String id ,
    String name,
    @Column("unit_type") String unitType,
    Integer price
) {
}
