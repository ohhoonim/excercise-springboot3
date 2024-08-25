package dev.ohhoonim.jdbc_query_dsl.orderlines.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderLine {
    private Long id;
    private List<Order> orders;
}
