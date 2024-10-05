package dev.ohhoonim.jdbc_query_dsl.domain.inventories.model.port;

import java.util.Optional;

import dev.ohhoonim.jdbc_query_dsl.domain.inventories.model.Product;

public interface InventoriesQuery {

    Optional<Product> getProductInfo(String id);

}
