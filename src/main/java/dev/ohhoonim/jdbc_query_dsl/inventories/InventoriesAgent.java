package dev.ohhoonim.jdbc_query_dsl.inventories;

import org.springframework.stereotype.Service;

import dev.ohhoonim.jdbc_query_dsl.inventories.model.InventoriesStory;
import dev.ohhoonim.jdbc_query_dsl.inventories.model.Product;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoriesAgent implements InventoriesStory {
    @Override
    public void addProductInfo(Product newProduct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addProductInfo'");
    }

    @Override
    public void modifyProductInfo(String productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifyProductInfo'");
    }

    @Override
    public Product getProductInfo(String productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductInfo'");
    }

    @Override
    public void modifyProductQty(Product product, int qty) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modifyProductQty'");
    }

    @Override
    public int getProductQty(String productId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProductQty'");
    }
    
}
