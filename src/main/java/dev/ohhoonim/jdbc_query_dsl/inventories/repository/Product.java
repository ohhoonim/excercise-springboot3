package dev.ohhoonim.jdbc_query_dsl.inventories.repository;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("product")
public record Product(
    @Id String id ,
    String name,
    String unitType,
    Integer price
) {

    public dev.ohhoonim.jdbc_query_dsl.inventories.model.Product toProduct() {
        return new dev.ohhoonim.jdbc_query_dsl.inventories.model.Product(id, name, unitType, price);
    }
}
