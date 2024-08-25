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

    private List<Order> orders = new ArrayList<>();

    private final OrderLineRepository orderLineRepository;
    
    @Override
    public void addOrder(Order order) {
        this.orders.add(order);
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
    public int getTotalPrice() {
        return orders.stream().mapToInt(Order::getTotalPrice).sum();
    }

    @Override
    public Integer orderlineCount() {
        var byProduct = orders.stream().collect(groupingBy(getProductInfo));
        return byProduct.size();
    }

    @Override
    public List<Order> getFinalOrderLine() {
        var byProduct = orders.stream().collect(groupingBy(getProductInfo, Collectors.summingInt(Order::getQty)));

        return byProduct.entrySet().stream().map(e -> {
            var pInfo = e.getKey();
            var qty = e.getValue();
            return new Order(
                    pInfo.orderId(),
                    LocalDateTime.now(),
                    pInfo.productId(),
                    pInfo.productName(),
                    pInfo.unitType(),
                    pInfo.productPrice(),
                    qty);
        })
                .toList();
    }

    private final Function<Order, ProductInfo> getProductInfo = (o) -> {
        return new ProductInfo(o.getId(), o.getProductId(), o.getProductName(), o.getProductUnitType(), o.getProductPrice());
    };

    record ProductInfo(
            int orderId,
            String productId,
            String productName,
            String unitType,
            int productPrice) {
    }

    @Override
    public void init() {
        orders.clear(); 
    }
}
