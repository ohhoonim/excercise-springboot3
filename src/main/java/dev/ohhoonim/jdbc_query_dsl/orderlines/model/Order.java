package dev.ohhoonim.jdbc_query_dsl.orderlines.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private LocalDateTime orderDate;
    private String productId;
    private String productName;
    private String productUnitType;
    private int productPrice;
    private String unitType;

    private Integer qty;

    public Order(LocalDateTime orderDate, String productId, String productName, String unitType, int productPrice, int qty) {
        this.orderDate = orderDate;
        this.productId = productId;
        this.productName = productName;
        this.productUnitType = unitType;
        this.productPrice = productPrice;
        this.qty = qty;
    }

    public Integer getTotalPrice() {
        return productPrice * qty;
    }

}
