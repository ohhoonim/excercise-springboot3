package dev.ohhoonim.jdbc_query_dsl.inventories.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private String unitType;
    private Integer price;

    public Product(String id, String name, String unitType) {
        this.id = id;
        this.name = name;
        this.unitType = unitType;
        this.price = 0;
    }

    public Product(String id, String name, String unitType, int price) {
        this.id = id;
        this.name = name;
        this.unitType = unitType;
        this.price = price;
    }

}
