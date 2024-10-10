package dev.ohhoonim.jdbc_query_dsl.repository;

import com.infobip.spring.data.jdbc.QuerydslJdbcRepository;

import dev.ohhoonim.jdbc_query_dsl.table.OrderLineTable;

public interface OrderLineRepository extends QuerydslJdbcRepository<OrderLineTable, Integer>{

}
