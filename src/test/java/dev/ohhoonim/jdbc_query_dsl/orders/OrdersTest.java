package dev.ohhoonim.jdbc_query_dsl.orders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.ohhoonim.jdbc_query_dsl.inventories.model.Product;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.Order;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.OrderLine;

@ExtendWith(MockitoExtension.class)
public class OrdersTest {
    
    @Test
    void ordersGetTotalPrice() {

        OrderLine orderLine = new OrderLine();
        orderLine.add(new Order(new Product("20240801-001", "merona", "kg", 1000), 2));
        orderLine.add(new Order(new Product("20240801-002", "bibibig", "ea", 2000), 3));
        orderLine.add(new Order(new Product("20240801-003", "zuzuba", "ea", 3000), 5));

        assertEquals(23000, orderLine.getTotalPrice());
    }

    @Test
    void ordersZeroTotalPrice() {
        OrderLine orderLine = new OrderLine();
        assertEquals(0, orderLine.getTotalPrice());
    }
}
