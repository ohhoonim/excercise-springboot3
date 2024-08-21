package dev.ohhoonim.jdbc_query_dsl.orderlines.model;

import static java.util.stream.Collectors.groupingBy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderLine {
    private List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        this.orders.add(order);
    }

    public int getTotalPrice() {
        return orders.stream().mapToInt(Order::getTotalPrice).sum();
    }

    /**
     * count는 상품수 기준(갯수아님)
     * @return
     */
	public Integer orderlineCount() {
        var byProduct = orders.stream().collect(groupingBy(getProductInfo));
        return byProduct.size();
	}

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
                qty
            );
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
        int productPrice
    ){}
}
