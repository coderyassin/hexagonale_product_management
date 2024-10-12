package org.alten.product_management.infrastructure.adapter.output.db.mysql.service;

import org.alten.product_management.domain.exception.ResourceNotFoundException;
import org.alten.product_management.domain.model.Product;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.entity.ProductEntity;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.mapper.ProductMapper;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.repository.ProductRepository;
import org.alten.product_management.infrastructure.adapter.output.db.service.DeleteProductService;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.alten.product_management.domain.constant.ProductConstant.PRODUCT_NOT_FOUND;

@Component("DeleteProductFromMySql")
public class DeleteProduct implements DeleteProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public DeleteProduct(ProductRepository productRepository,
                         ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product deleteProduct(String productId) {
        if (productRepository.existsById(productId)) {
            Optional<ProductEntity> productEntity = productRepository.findById(productId);
            productRepository.deleteById(productId);
            return productEntity.map(productMapper::fromEntityToDomain).get();
        }

        String message = String.format(PRODUCT_NOT_FOUND, productId);
        throw new ResourceNotFoundException(message);
    }
}
