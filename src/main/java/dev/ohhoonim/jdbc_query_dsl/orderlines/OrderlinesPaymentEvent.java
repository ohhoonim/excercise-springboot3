package dev.ohhoonim.jdbc_query_dsl.orderlines;

import java.time.LocalDateTime;

import org.springframework.modulith.events.Externalized;

@Externalized(target = "orderLines-payment")
public record OrderlinesPaymentEvent(
        LocalDateTime order,
        Integer qty,
        String productId) {

}
// inventories에서 판매된 수량만큼 재고 감소