package dev.ohhoonim.jdbc_query_dsl.inventories.repository;

import org.springframework.data.repository.ListCrudRepository;

public interface ProductRepository extends ListCrudRepository<Product, String>{
    
}
