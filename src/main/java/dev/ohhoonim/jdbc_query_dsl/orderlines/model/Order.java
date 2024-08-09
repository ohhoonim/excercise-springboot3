package dev.ohhoonim.jdbc_query_dsl.orderlines.model;

import dev.ohhoonim.jdbc_query_dsl.inventories.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Order {
    private Product product;
    private Integer qty;

    public Order(Product product, int qty) {
        this.product = product;
        this.qty = qty;
    }

    public Integer getTotalPrice() {
        return product.getPrice() * qty;
    }

}
