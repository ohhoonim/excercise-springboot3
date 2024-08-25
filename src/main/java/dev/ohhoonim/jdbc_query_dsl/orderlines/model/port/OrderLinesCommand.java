package dev.ohhoonim.jdbc_query_dsl.orderlines.model.port;

import dev.ohhoonim.jdbc_query_dsl.orderlines.model.Order;

public interface OrderLinesCommand {

    void addOrder(Order order);

    void init();

}
