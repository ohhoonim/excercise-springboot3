package dev.ohhoonim.jdbc_query_dsl.repository;

import org.springframework.data.repository.ListCrudRepository;

import dev.ohhoonim.jdbc_query_dsl.table.OrderLineTable;

public interface OrderLineRepository extends ListCrudRepository<OrderLineTable, Integer>{

}
