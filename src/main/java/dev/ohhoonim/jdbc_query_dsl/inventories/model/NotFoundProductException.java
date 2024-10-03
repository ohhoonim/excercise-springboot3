package dev.ohhoonim.jdbc_query_dsl.inventories.model;

public class NotFoundProductException extends RuntimeException{
    public NotFoundProductException(String id) {
        super("Not Found Product : " + id);
    }

    public NotFoundProductException(String id, Throwable cause) {
        super("Not Found Product : " + id, cause);
    }
}
