package dev.ohhoonim.jdbc_query_dsl.orderlines.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.ohhoonim.jdbc_query_dsl.orderlines.OrderlinesPaymentEvent;
import lombok.RequiredArgsConstructor;

@Service("orderLinesStory")
@RequiredArgsConstructor
@Transactional
public class OrderLinesStory {

    private final OrderLinesCommand orderLinesCommand;
    private final OrderLinesQuery orderLinesQuery;
    private final ApplicationEventPublisher publisher;

    public void add(Order order) {
        orderLinesCommand.add(order);
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
