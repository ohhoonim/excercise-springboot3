package dev.ohhoonim.jdbc_query_dsl.inventories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import dev.ohhoonim.jdbc_query_dsl.inventories.model.Product;
import dev.ohhoonim.jdbc_query_dsl.inventories.model.InventoriesCommandPort;
import dev.ohhoonim.jdbc_query_dsl.inventories.model.InventoriesQueryPort;
import dev.ohhoonim.jdbc_query_dsl.inventories.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class InventoriesAdapter implements InventoriesQueryPort, InventoriesCommandPort {

    private final ProductRepository productRepository;

    @Override
    public void addProduct(Product product) {
        productRepository.save(product.toProduct());
    }

    @Override
    public List<Product> getProductList() {
        return productRepository.findAll().stream().map(p -> p.toProduct()).toList();
    }

    @Override
    public Optional<Product> getProduct(String id) {
        return productRepository.findById(id).stream().map(p -> p.toProduct()).findFirst();
    }
    
}
