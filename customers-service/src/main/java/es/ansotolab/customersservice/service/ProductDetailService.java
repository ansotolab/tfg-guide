package es.ansotolab.customersservice.service;

import es.ansotolab.customersservice.exception.ProductDetailNotFound;
import es.ansotolab.customersservice.model.Customer;
import es.ansotolab.customersservice.model.ProductDetail;
import es.ansotolab.customersservice.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDetailService {

    @Autowired
    private ProductDetailRepository productDetailRepository;

    public ProductDetail saveProductDetail(ProductDetail productDetail) {
        return productDetailRepository.save(productDetail);
    }

    public ProductDetail updateProductDetail(ProductDetail productDetail) {
        Optional<ProductDetail> productDetailSearched = productDetailRepository.findById(productDetail.getId());

        if (!productDetailSearched.isPresent())
        {
            throw new ProductDetailNotFound(productDetail.getId());
        }
        else
        {
            productDetailSearched.get().setText(productDetail.getText());
            return productDetailRepository.save(productDetailSearched.get());
        }
    }

    public ProductDetail getProductDetail(long id) {
        Optional<ProductDetail> productDetailSearched = productDetailRepository.findById(id);

        if (!productDetailSearched.isPresent())
        {
            throw new ProductDetailNotFound(id);
        }
        else
        {
            return productDetailSearched.get();
        }
    }
}
