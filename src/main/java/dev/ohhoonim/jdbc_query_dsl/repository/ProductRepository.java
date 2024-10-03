package dev.ohhoonim.jdbc_query_dsl.repository;

import org.springframework.data.repository.ListCrudRepository;

import dev.ohhoonim.jdbc_query_dsl.table.ProductTable;

public interface ProductRepository extends ListCrudRepository<ProductTable, String>{
    
}