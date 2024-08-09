package dev.ohhoonim.jdbc_query_dsl.inventories.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ohhoonim.jdbc_query_dsl.inventories.InventoriesAgent;
import dev.ohhoonim.jdbc_query_dsl.inventories.model.Product;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductApi {

    private final InventoriesAgent productAgent;
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> product(@PathVariable String id) {
        return ResponseEntity.ok(productAgent.getProductInfo(id));
    }
}
