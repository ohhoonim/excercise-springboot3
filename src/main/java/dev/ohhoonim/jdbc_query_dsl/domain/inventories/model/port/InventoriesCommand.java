package dev.ohhoonim.jdbc_query_dsl.domain.inventories.model.port;

import dev.ohhoonim.jdbc_query_dsl.domain.inventories.model.Product;

public interface InventoriesCommand {

    void addProductInfo(Product newProduct);

}
