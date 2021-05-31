package es.ansotolab.customersservice.exception;

public class ProductDetailNotFound extends RuntimeException {
    public ProductDetailNotFound(long id) {
        super("The product detail with id: " + id + " does not exist.");
    }
}
