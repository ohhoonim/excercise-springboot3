package dev.ohhoonim.jdbc_query_dsl.repository;

import com.infobip.spring.data.jdbc.QuerydslJdbcRepository;

import dev.ohhoonim.jdbc_query_dsl.table.ProductTable;

public interface ProductRepository extends QuerydslJdbcRepository<ProductTable, String>{
    
}