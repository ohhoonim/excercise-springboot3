package dev.ohhoonim.jdbc_query_dsl.inventories.service;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import dev.ohhoonim.jdbc_query_dsl.inventories.model.Product;

@Table("product")
public record ProductTable (
    @Id String id ,
    String name,
    @Column("unit_type") String unitType,
    Integer price
) {

    public Product toProduct() {
        return new Product(id, name, unitType, price);
    }
}
