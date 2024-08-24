package dev.ohhoonim.jdbc_query_dsl.orderlines;

import java.time.LocalDateTime;

import org.springframework.modulith.events.Externalized;

@Externalized(target = "orderLines-payment")
public record OrderlinesPaymentEvent(
        LocalDateTime order,
        Integer qty,
        String productId) {

}
