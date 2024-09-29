package org.alten.product_management.application.port.input.api;

import org.alten.product_management.application.adapter.input.controller.request.CreateProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.alten.product_management.application.common.util.ApiPaths.Product.PRODUCTS;
import static org.alten.product_management.application.common.util.ApiPaths.Product.PRODUCT_ID;

@RequestMapping(PRODUCTS)
public interface ProductApi {
    @GetMapping
    ResponseEntity<?> getProducts();

    @GetMapping(PRODUCT_ID)
    ResponseEntity<?> getProduct(@PathVariable Long productId);

    @PostMapping
    ResponseEntity<?> createProduct(@RequestBody CreateProductRequest createProductRequest);

}
