package dev.ohhoonim.jdbc_query_dsl.orderlines.model;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.ohhoonim.jdbc_query_dsl.orderlines.OrderlinesPaymentEvent;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.port.OrderLinesCommand;
import lombok.RequiredArgsConstructor;

@Service("orderLinesService")
@RequiredArgsConstructor
@Transactional
public class OrderLinesService {

    private final OrderLinesCommand orderLinesCommand;
    private final ApplicationEventPublisher publisher;

    public void addOrder(Order order) {
        orderLinesCommand.addOrder(order);
    }

    
    // sample : publish event to product
    public void sendEvent() {
        
        var event = new OrderlinesPaymentEvent(
            LocalDateTime.now(),
            30,
            "1"
        );
        publisher.publishEvent(event);
    }
}
