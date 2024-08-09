package dev.ohhoonim.jdbc_query_dsl.orderlines.model;

import java.util.ArrayList;
import java.util.List;

public class OrderLine {
    private List<Order> orders = new ArrayList();

    public void add(Order order) {
        this.orders.add(order);
    }

    public int getTotalPrice() {
        return orders.stream().mapToInt(Order::getTotalPrice).sum();
    }

}
