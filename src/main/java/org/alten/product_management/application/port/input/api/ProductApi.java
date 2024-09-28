package org.alten.product_management.application.port.input.api;

import org.alten.product_management.application.adapter.input.controller.request.CreateProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.alten.product_management.application.common.util.ApiPaths.Product.PRODUCTS;

@RequestMapping(PRODUCTS)
public interface ProductApi {
    @PostMapping
    ResponseEntity<?> createProduct(@RequestBody CreateProductRequest createProductRequest);

}
