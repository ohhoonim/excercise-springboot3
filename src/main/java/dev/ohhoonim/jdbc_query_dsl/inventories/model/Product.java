package dev.ohhoonim.jdbc_query_dsl.inventories.model;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private String unitType;
    private Integer price;

    public Product(String id, String name, String unitType) {
        this.id = id;
        this.name = name;
        this.unitType = unitType;
    }

    public Product(String string, String string2, String string3, int price) {
        this.id = id;
        this.name = name;
        this.unitType = unitType;
        this.price = price;
    }

    public dev.ohhoonim.jdbc_query_dsl.inventories.repository.Product toProduct() {
        return new dev.ohhoonim.jdbc_query_dsl.inventories.repository.Product(this.id, this.name, this.unitType, this.price); 
    }
}
