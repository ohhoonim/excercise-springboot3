package dev.ohhoonim.jdbc_query_dsl.inventories.model;

public interface InventoriesStory {
    // 상품정보 생성
    void addProductInfo(Product newProduct);

    // 상품정보 수정
    void modifyProductInfo(String productId);

    // 상품정보 조회
    Product getProductInfo(String productId);

    // 상품 재고수량 수정
    void modifyProductQty(Product product, int qty); 

    // 상품 재고수량 조회
    int getProductQty(String productId);

    // 상품 보관 위치 목록

    // 보관 위치별 상품 목록

}
