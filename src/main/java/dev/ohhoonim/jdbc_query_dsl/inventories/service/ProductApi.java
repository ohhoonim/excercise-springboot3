package dev.ohhoonim.jdbc_query_dsl.inventories.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ohhoonim.jdbc_query_dsl.inventories.model.InventoriesService;
import dev.ohhoonim.jdbc_query_dsl.inventories.model.Product;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductApi {

    private final InventoriesService inventoriesService;
    
    @GetMapping("/{id}")
    public ResponseEntity<Product> product(@PathVariable String id) {
        return ResponseEntity.ok(inventoriesService.getProductInfo(id).get());
    }
}
