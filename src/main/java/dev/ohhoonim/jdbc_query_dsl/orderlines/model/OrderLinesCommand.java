package dev.ohhoonim.jdbc_query_dsl.orderlines.model;

public interface OrderLinesCommand {

    void add(Order order);

    void init();

}
