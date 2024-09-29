package org.alten.product_management.infrastructure.adapter.output.db.mysql.business;

import org.alten.product_management.domain.exception.ResourceNotFoundException;
import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.DeleteProductPort;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.entity.ProductEntity;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.mapper.ProductMapper;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static org.alten.product_management.domain.constant.ProductConstant.PRODUCT_NOT_FOUND;

@Component
public class DeleteProductAdapter implements DeleteProductPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public DeleteProductAdapter(ProductRepository productRepository,
                                ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product deleteProduct(Long productId) {
        if (productRepository.existsById(productId)) {
            Optional<ProductEntity> productEntity = productRepository.findById(productId);
            productRepository.deleteById(productId);
            return productEntity.map(productMapper::fromEntityToDomain).get();
        }

        String message = String.format(PRODUCT_NOT_FOUND, productId);
        throw new ResourceNotFoundException(message);
    }
}
