package dev.ohhoonim.jdbc_query_dsl.orders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.ohhoonim.jdbc_query_dsl.orderlines.model.Order;
import dev.ohhoonim.jdbc_query_dsl.orderlines.model.OrderLinesStory;

@SpringBootTest
public class OrderLinesTest {

    @Autowired
    OrderLinesStory orderLinesStory;

    record Product(
        String id ,
        String name,
        String unitType,
        Integer price
    ) {}

    @BeforeEach
    void setUp() {
        orderLinesStory.orderLinesInit();
    }
    
    @Test
    void ordersGetTotalPrice() {
        var merona = new Product("20240801-001", "merona", "kg", 1000);
        var bibibig = new Product("20240801-002", "bibibig", "ea", 2000);
        var zuzuba = new Product("20240801-003", "zuzuba", "ea", 3000);
        orderLinesStory.add(new Order(LocalDateTime.now(), merona.id(), merona.name(), merona.unitType(), merona.price(), 2));
        orderLinesStory.add(new Order(LocalDateTime.now(), bibibig.id(), bibibig.name(), bibibig.unitType(), bibibig.price(), 3));
        orderLinesStory.add(new Order(LocalDateTime.now(), zuzuba.id(), zuzuba.name(), zuzuba.unitType(), zuzuba.price(), 5));

        assertEquals(23000, orderLinesStory.getTotalPrice());
    }

    @Test
    void ordersZeroTotalPrice() {
        assertEquals(0, orderLinesStory.getTotalPrice());
    }

    @Test
    void add() {
        var merona = new Product("20240801-001", "merona", "kg", 1000);
        var bibibig = new Product("20240801-002", "bibibig", "ea", 2000);
        var zuzuba = new Product("20240801-003", "zuzuba", "ea", 3000);
        orderLinesStory.add(new Order(LocalDateTime.now(), merona.id(), merona.name(), merona.unitType(), merona.price(), 2));
        orderLinesStory.add(new Order(LocalDateTime.now(), bibibig.id(), bibibig.name(), bibibig.unitType(), bibibig.price(), 3));
        orderLinesStory.add(new Order(LocalDateTime.now(), zuzuba.id(), zuzuba.name(), zuzuba.unitType(), zuzuba.price(), 5));
        orderLinesStory.add(new Order(LocalDateTime.now(), merona.id(), merona.name(), merona.unitType(), merona.price(), 1));
        assertEquals(3, orderLinesStory.orderlineCount());
    }

    @Test
    void getFinalOrderLine() {
        var merona = new Product("20240801-001", "merona", "kg", 1000);
        var bibibig = new Product("20240801-002", "bibibig", "ea", 2000);
        var zuzuba = new Product("20240801-003", "zuzuba", "ea", 3000);
        orderLinesStory.add(new Order(LocalDateTime.now(), merona.id(), merona.name(), merona.unitType(), merona.price(), 2));
        orderLinesStory.add(new Order(LocalDateTime.now(), bibibig.id(), bibibig.name(), bibibig.unitType(), bibibig.price(), 3));
        orderLinesStory.add(new Order(LocalDateTime.now(), zuzuba.id(), zuzuba.name(), zuzuba.unitType(), zuzuba.price(), 5));
        orderLinesStory.add(new Order(LocalDateTime.now(), merona.id(), merona.name(), merona.unitType(), merona.price(), 7));
        assertEquals(9, orderLinesStory.getFinalOrderLine().stream().filter( o -> o.getProductId().equals("20240801-001")).findFirst().get().getQty());
    }

}
