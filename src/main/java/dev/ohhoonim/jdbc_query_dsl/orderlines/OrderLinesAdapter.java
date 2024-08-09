package dev.ohhoonim.jdbc_query_dsl.orderlines;

import org.springframework.stereotype.Component;

import dev.ohhoonim.jdbc_query_dsl.orderlines.model.OrderLinesCommandPort;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.OrderLinesQueryPort;

@Component
public class OrderLinesAdapter implements OrderLinesQueryPort, OrderLinesCommandPort {
    
}
