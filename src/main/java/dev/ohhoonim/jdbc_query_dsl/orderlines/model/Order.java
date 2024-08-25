package dev.ohhoonim.jdbc_query_dsl.orderlines.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private int id;
    private LocalDateTime orderDate;
    private String productId;
    private String productName;
    private String productUnitType;
    private int productPrice;
    private int qty;

    public Integer getTotalPrice() {
        return productPrice * qty;
    }

}
