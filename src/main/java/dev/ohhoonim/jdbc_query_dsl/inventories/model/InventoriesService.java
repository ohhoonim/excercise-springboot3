package dev.ohhoonim.jdbc_query_dsl.inventories.model;

import java.util.Optional;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.ohhoonim.jdbc_query_dsl.inventories.model.port.InventoriesCommand;
import dev.ohhoonim.jdbc_query_dsl.inventories.model.port.InventoriesQuery;
import dev.ohhoonim.jdbc_query_dsl.orderlines.OrderlinesPaymentEvent;
import lombok.RequiredArgsConstructor;

@Service("inventoriesService")
@RequiredArgsConstructor
@Transactional
public class InventoriesService {

    private final InventoriesCommand inventoriesCommand;
    private final InventoriesQuery inventoriesQuery;

    // 상품정보 생성
    public void addProductInfo(Product newProduct) {
        inventoriesCommand.addProductInfo(newProduct);
    }

    // 상품정보 조회
    public Optional<Product> getProductInfo(String productId) {
        return inventoriesQuery.getProductInfo(productId);
    }

    @ApplicationModuleListener
    void on(OrderlinesPaymentEvent event) throws Exception {
        System.out.println("orderlines payment event -------------------");
        System.out.println(event.toString());
        System.out.println("orderlines payment event -------------------");
    }
}
