package dev.ohhoonim.jdbc_query_dsl.orderlines.service;

import static java.util.stream.Collectors.groupingBy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import dev.ohhoonim.jdbc_query_dsl.orderlines.OrderlinesPaymentEvent;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.Order;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.OrderLinesCommand;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.OrderLinesQuery;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderLinesAdapter implements OrderLinesQuery, OrderLinesCommand {

    private List<Order> orders = new ArrayList<>();
    
    @Override
    public void add(Order order) {
        this.orders.add(order);
    }

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
        return new ProductInfo(o.getProductId(), o.getProductName(), o.getUnitType(), o.getProductPrice());
    };

    record ProductInfo(
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
