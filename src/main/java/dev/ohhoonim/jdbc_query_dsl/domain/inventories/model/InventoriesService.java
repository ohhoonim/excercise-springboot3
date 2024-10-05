package dev.ohhoonim.jdbc_query_dsl.domain.inventories.model;

import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.ohhoonim.jdbc_query_dsl.domain.inventories.model.port.InventoriesCommand;
import dev.ohhoonim.jdbc_query_dsl.domain.inventories.model.port.InventoriesQuery;
import dev.ohhoonim.jdbc_query_dsl.domain.orderlines.OrderlinesPaymentEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service("inventoriesService")
@RequiredArgsConstructor
@Transactional
@Slf4j
public class InventoriesService {

    private final InventoriesCommand inventoriesCommand;
    private final InventoriesQuery inventoriesQuery;

    // 상품정보 생성
    public void addProductInfo(Product newProduct) {
        inventoriesCommand.addProductInfo(newProduct);
    }

    // 상품정보 조회
    public Product getProductInfo(String productId) throws NotFoundProductException {
        var product = inventoriesQuery.getProductInfo(productId);
        if (product.isEmpty()) {
            throw new NotFoundProductException(productId);
        }
        return product.get();
    }

    @ApplicationModuleListener
    void on(OrderlinesPaymentEvent event) throws Exception {
        log.info("========== {}", event.toString());
    }
}
