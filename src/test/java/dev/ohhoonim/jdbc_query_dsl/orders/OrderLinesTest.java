package dev.ohhoonim.jdbc_query_dsl.orders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.ohhoonim.jdbc_query_dsl.orderlines.model.Order;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.OrderLine;

@ExtendWith(MockitoExtension.class)
public class OrderLinesTest {
    private OrderLine orderLine ;

    @BeforeEach
    void setUp() {
        var merona = new Product("20240801-001", "merona", "kg", 1000);
        var bibibig = new Product("20240801-002", "bibibig", "ea", 2000);
        var zuzuba = new Product("20240801-003", "zuzuba", "ea", 3000);
        orderLine = new OrderLine();
        orderLine.add(new Order(LocalDateTime.now(), merona.id(), merona.name(), merona.unitType(), merona.price(), 2));
        orderLine.add(new Order(LocalDateTime.now(), bibibig.id(), bibibig.name(), bibibig.unitType(), bibibig.price(), 3));
        orderLine.add(new Order(LocalDateTime.now(), zuzuba.id(), zuzuba.name(), zuzuba.unitType(), zuzuba.price(), 5));
    }

    record Product(
        String id ,
        String name,
        String unitType,
        Integer price
    ) {}
    
    @Test
    void ordersGetTotalPrice() {
        assertEquals(23000, orderLine.getTotalPrice());
    }

    @Test
    @DisplayName("주문목록에 주문이 없는 경우")
    void ordersZeroTotalPrice() {
        OrderLine orderLine = new OrderLine();
        assertEquals(0, orderLine.getTotalPrice());
    }

    @Test
    void add() {
        var merona = new Product("20240801-001", "merona", "kg", 1000);
        orderLine.add(new Order(LocalDateTime.now(), merona.id(), merona.name(), merona.unitType(), merona.price(), 1));
        assertEquals(3, orderLine.orderlineCount());
    }

    @Test
    void getFinalOrderLine() {
        var merona = new Product("20240801-001", "merona", "kg", 1000);
        orderLine.add(new Order(LocalDateTime.now(), merona.id(), merona.name(), merona.unitType(), merona.price(), 7));
        assertEquals(9, orderLine.getFinalOrderLine().stream().filter( o -> o.getProductId().equals("20240801-001")).findFirst().get().getQty());

    }

}
