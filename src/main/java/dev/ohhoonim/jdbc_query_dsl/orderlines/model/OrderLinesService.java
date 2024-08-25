package dev.ohhoonim.jdbc_query_dsl.orderlines.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.ohhoonim.jdbc_query_dsl.orderlines.OrderlinesPaymentEvent;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.port.OrderLinesCommand;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.port.OrderLinesQuery;
import lombok.RequiredArgsConstructor;

@Service("orderLinesService")
@RequiredArgsConstructor
@Transactional
public class OrderLinesService {

    private final OrderLinesCommand orderLinesCommand;
    private final OrderLinesQuery orderLinesQuery;
    private final ApplicationEventPublisher publisher;

    public void addOrder(Order order) {
        orderLinesCommand.addOrder(order);
    }

    public int getTotalPrice() {
        return orderLinesQuery.getTotalPrice();
    }

    public Integer orderlineCount() {
        return orderLinesQuery.orderlineCount();
    }

    public List<Order> getFinalOrderLine() {
        return orderLinesQuery.getFinalOrderLine();
    }

    public void orderLinesInit() {
       orderLinesCommand.init(); 
    }

    public void sendEvent() {
        
        var event = new OrderlinesPaymentEvent(
            LocalDateTime.now(),
            30,
            "1"
        );
        publisher.publishEvent(event);
    }
}
