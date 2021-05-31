package es.ansotolab.customersservice.repository;

import es.ansotolab.customersservice.model.ProductDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductDetailRepository extends CrudRepository<ProductDetail, Long> {
    public Optional<ProductDetail> findById(long id);
}
