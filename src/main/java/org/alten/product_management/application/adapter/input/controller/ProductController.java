package org.alten.product_management.application.adapter.input.controller;

import org.alten.product_management.application.adapter.input.controller.request.CreateProductRequest;
import org.alten.product_management.application.adapter.input.controller.response.CreateProductResponse;
import org.alten.product_management.application.adapter.input.controller.response.DeleteProductResponse;
import org.alten.product_management.application.common.mapper.ProductMapper;
import org.alten.product_management.application.port.input.api.ProductApi;
import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.input.AllProductsUseCase;
import org.alten.product_management.domain.port.input.CreateProductUseCase;
import org.alten.product_management.domain.port.input.DeleteProductUseCase;
import org.alten.product_management.domain.port.input.ProductByIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController implements ProductApi {
    private final CreateProductUseCase createProductUseCase;
    private final AllProductsUseCase allProductsUseCase;
    private final ProductByIdUseCase productByIdUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final ProductMapper productMapper;

    public ProductController(CreateProductUseCase createProductUseCase,
                             AllProductsUseCase allProductsUseCase,
                             ProductByIdUseCase productByIdUseCase,
                             DeleteProductUseCase deleteProductUseCase,
                             ProductMapper productMapper) {
        this.createProductUseCase = createProductUseCase;
        this.allProductsUseCase = allProductsUseCase;
        this.productByIdUseCase = productByIdUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.productMapper = productMapper;
    }

    @Override
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(allProductsUseCase.allProducts());
    }

    @Override
    public ResponseEntity<?> getProduct(Long productId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productByIdUseCase.productById(productId));
    }

    @Override
    public ResponseEntity<?> createProduct(CreateProductRequest createProductRequest) {
        Product product = productMapper.toModel(createProductRequest);
        Product productCreated = createProductUseCase.createProduct(product);
        CreateProductResponse createProductResponse = productMapper.toCreateProductResponse(productCreated);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(createProductResponse);
    }

    @Override
    public ResponseEntity<?> deleteProduct(Long productId) {
        DeleteProductResponse deleteProductResponse =
                productMapper.toDeleteProductResponse(deleteProductUseCase.deleteProduct(productId));

        return ResponseEntity.status(HttpStatus.OK)
                .body(deleteProductResponse);
    }
}
