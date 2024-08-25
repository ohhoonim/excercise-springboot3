package dev.ohhoonim.jdbc_query_dsl.orderlines.model.port;

import java.util.List;

import dev.ohhoonim.jdbc_query_dsl.orderlines.model.Order;

public interface OrderLinesQuery {

    int getTotalPrice();

    Integer orderlineCount();

    List<Order> getFinalOrderLine();


}
