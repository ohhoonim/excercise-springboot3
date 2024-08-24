package dev.ohhoonim.jdbc_query_dsl.orderlines.model;

import java.util.List;

public interface OrderLinesQuery {

    int getTotalPrice();

    Integer orderlineCount();

    List<Order> getFinalOrderLine();


}
