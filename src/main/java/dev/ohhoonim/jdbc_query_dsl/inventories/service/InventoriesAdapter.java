package dev.ohhoonim.jdbc_query_dsl.inventories.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import dev.ohhoonim.jdbc_query_dsl.inventories.model.InventoriesCommand;
import dev.ohhoonim.jdbc_query_dsl.inventories.model.InventoriesQuery;
import dev.ohhoonim.jdbc_query_dsl.inventories.model.Product;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoriesAdapter implements InventoriesQuery, InventoriesCommand {

    private final ProductRepository productRepository;

    @Override
    public void addProductInfo(Product product) {
        var productVo = Optional.ofNullable(product).map(productTableMapper).get();
        productRepository.save(productVo);
    }

    @Override
    public Optional<Product> getProductInfo(String id) {
        return productRepository.findById(id).stream().map(p -> p.toProduct()).findFirst();
    }


    Function<Product, ProductTable> productTableMapper = p -> {
        return new ProductTable(p.getId(), p.getName(), p.getUnitType(), p.getPrice());
    };
}
