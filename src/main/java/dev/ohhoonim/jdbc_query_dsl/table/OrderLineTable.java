package dev.ohhoonim.jdbc_query_dsl.table;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("order_line_table")
public record OrderLineTable(
    @Id  int id,
    @Column("order_date") LocalDateTime orderDate,
    @Column("product_id") String productId,
    @Column("product_name") String productName,
    @Column("product_unit_type") String productUnitType,
    @Column("product_price") int productPrice,
    @Column("qty") Integer qty
) {

}
