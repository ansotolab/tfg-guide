package es.ansotolab.customersservice.controller;

import es.ansotolab.customersservice.model.ProductDetail;
import es.ansotolab.customersservice.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/details")
public class ProductDetailController {

    @Autowired
    private Environment env;

    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("/{id}")
    public ProductDetail getDetails(@PathVariable long id) {
        return productDetailService.getProductDetail(id);
    }

    @PutMapping("/{id}")
    public ProductDetail updateDetails(@PathVariable long id, @Valid @RequestBody ProductDetail productDetail) {
        productDetail.setId(id);
        return productDetailService.updateProductDetail(productDetail);
    }
}
