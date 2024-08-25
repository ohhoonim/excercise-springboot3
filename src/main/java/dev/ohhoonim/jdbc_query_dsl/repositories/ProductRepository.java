package dev.ohhoonim.jdbc_query_dsl.repositories;

import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<ProductTable, String>{
    
}