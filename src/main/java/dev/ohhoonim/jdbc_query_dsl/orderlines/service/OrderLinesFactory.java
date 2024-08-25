package dev.ohhoonim.jdbc_query_dsl.orderlines.service;

import static java.util.stream.Collectors.groupingBy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import dev.ohhoonim.jdbc_query_dsl.orderlines.model.Order;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.port.OrderLinesCommand;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.port.OrderLinesQuery;
import dev.ohhoonim.jdbc_query_dsl.repositories.OrderLineRepository;
import dev.ohhoonim.jdbc_query_dsl.repositories.OrderLineTable;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderLinesFactory implements OrderLinesQuery, OrderLinesCommand {


    private final OrderLineRepository orderLineRepository;
    
    @Override
    public void addOrder(Order order) {
        orderLineRepository.save(orderLineMapper.apply(order));
    }

    private Function<Order, OrderLineTable> orderLineMapper = order -> {
        return new OrderLineTable(
                order.getId(),
                order.getOrderDate(),
                order.getProductId(),
                order.getProductName(),
                order.getProductUnitType(),
                order.getProductPrice(),
                order.getQty()
        ); };

    @Override
    public void init() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'init'");
    }

    @Override
    public int getTotalPrice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotalPrice'");
    }

    @Override
    public Integer orderlineCount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'orderlineCount'");
    }

    @Override
    public List<Order> getFinalOrderLine() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFinalOrderLine'");
    }

}
