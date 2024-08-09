package dev.ohhoonim.jdbc_query_dsl.inventories.model;

import java.util.List;
import java.util.Optional;

public interface InventoriesQueryPort {

    List<Product> getProductList();

    Optional<Product> getProduct(String id);

}
