package dev.ohhoonim.jdbc_query_dsl.domain.inventories.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import dev.ohhoonim.jdbc_query_dsl.domain.inventories.model.Product;
import dev.ohhoonim.jdbc_query_dsl.domain.inventories.model.port.InventoriesCommand;
import dev.ohhoonim.jdbc_query_dsl.domain.inventories.model.port.InventoriesQuery;
import dev.ohhoonim.jdbc_query_dsl.repository.ProductRepository;
import dev.ohhoonim.jdbc_query_dsl.table.ProductTable;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoriesFactory implements InventoriesQuery, InventoriesCommand {

    private final ProductRepository productRepository;

    @Override
    public void addProductInfo(Product product) {
        var productVo = Optional.ofNullable(product).map(productTableMapper).get();
        productRepository.save(productVo);
    }

    @Override
    @Cacheable(value = "Product", key = "#root.methodName + '-' + #id",  
        cacheManager = "redisCacheManager", unless = "#result == null")
    public Optional<Product> getProductInfo(String id) {
        return productRepository.findById(id).stream().map(productMapper).findFirst();
    }

    Function<Product, ProductTable> productTableMapper = p -> {
        return new ProductTable(p.getId(), p.getName(), p.getUnitType(), p.getPrice());
    };

    Function<ProductTable, Product> productMapper = p -> {
        return new Product(p.id(), p.name(), p.unitType(), p.price());
    };
}
