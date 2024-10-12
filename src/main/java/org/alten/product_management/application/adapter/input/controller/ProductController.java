package org.alten.product_management.application.adapter.input.controller;

import org.alten.product_management.application.adapter.input.controller.request.CreateProductRequest;
import org.alten.product_management.application.adapter.input.controller.request.UpdateProductRequest;
import org.alten.product_management.application.adapter.input.controller.response.CreateProductResponse;
import org.alten.product_management.application.adapter.input.controller.response.DeleteProductResponse;
import org.alten.product_management.application.adapter.input.controller.response.UpdateProductResponse;
import org.alten.product_management.application.common.mapper.ProductMapper;
import org.alten.product_management.application.port.input.api.ProductApi;
import org.alten.product_management.application.tracing.annotation.Loggable;
import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.input.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Loggable
public class ProductController implements ProductApi {
    private final CreateProductUseCase createProductUseCase;
    private final AllProductsUseCase allProductsUseCase;
    private final ProductByIdUseCase productByIdUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final ProductMapper productMapper;

    public ProductController(CreateProductUseCase createProductUseCase,
                             AllProductsUseCase allProductsUseCase,
                             ProductByIdUseCase productByIdUseCase,
                             UpdateProductUseCase updateProductUseCase,
                             DeleteProductUseCase deleteProductUseCase,
                             ProductMapper productMapper) {
        this.createProductUseCase = createProductUseCase;
        this.allProductsUseCase = allProductsUseCase;
        this.productByIdUseCase = productByIdUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.productMapper = productMapper;
    }

    @Override
    public ResponseEntity<?> getProducts() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(allProductsUseCase.allProducts());
    }

    @Override
    public ResponseEntity<?> getProduct(String productId) {
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
    public ResponseEntity<?> updateProduct(UpdateProductRequest updateProductRequest, String productId) {
        Product product = productMapper.toModel(updateProductRequest);
        Product productUpdated = updateProductUseCase.updateProduct(product, productId);
        UpdateProductResponse updateProductResponse = productMapper.toUpdateProductResponse(productUpdated);

        return ResponseEntity.status(HttpStatus.OK)
                .body(updateProductResponse);
    }

    @Override
    public ResponseEntity<?> deleteProduct(String productId) {
        DeleteProductResponse deleteProductResponse =
                productMapper.toDeleteProductResponse(deleteProductUseCase.deleteProduct(productId));

        return ResponseEntity.status(HttpStatus.OK)
                .body(deleteProductResponse);
    }
}
