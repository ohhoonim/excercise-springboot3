package dev.ohhoonim.jdbc_query_dsl.inventories.model;

import java.util.Optional;

public interface InventoriesQuery {

    Optional<Product> getProductInfo(String id);

}
