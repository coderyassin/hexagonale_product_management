package org.alten.product_management.infrastructure.adapter.output.db.mysql.business;

import org.alten.product_management.domain.exception.ResourceNotFoundException;
import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.UpdateProductPort;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.entity.ProductEntity;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.mapper.ProductMapper;
import org.alten.product_management.infrastructure.adapter.output.db.mysql.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static org.alten.product_management.domain.constant.ProductConstant.PRODUCT_NOT_FOUND;

@Component
public class UpdateProductAdapter implements UpdateProductPort {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public UpdateProductAdapter(ProductRepository productRepository,
                                ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
        if (productRepository.existsById(productId)) {
            ProductEntity productEntity = buildProductDto(product, productRepository.findById(productId).get());
            productEntity.setId(productId);
            return productMapper.fromEntityToDomain(productRepository.save(productEntity));
        }

        String message = String.format(PRODUCT_NOT_FOUND, productId);
        throw new ResourceNotFoundException(message);
    }

    private ProductEntity buildProductDto(Product product, ProductEntity productEntity) {
        return ProductEntity.builder()
                .code(Objects.nonNull(product.getCode()) ? product.getCode() : productEntity.getCode())
                .name(Objects.nonNull(product.getName()) ? product.getName() : productEntity.getName())
                .description(Objects.nonNull(product.getDescription()) ? product.getDescription() : productEntity.getDescription())
                .image(Objects.nonNull(product.getImage()) ? product.getImage() : productEntity.getImage())
                .category(Objects.nonNull(product.getCategory()) ? product.getCategory() : productEntity.getCategory())
                .price(Objects.nonNull(product.getPrice()) ? product.getPrice() : productEntity.getPrice())
                .quantity(Objects.nonNull(product.getQuantity()) ? product.getQuantity() : productEntity.getQuantity())
                .internalReference(Objects.nonNull(product.getInternalReference()) ? product.getInternalReference() : productEntity.getInternalReference())
                .shellId(Objects.nonNull(product.getShellId()) ? product.getShellId() : productEntity.getShellId())
                .inventoryStatus(Objects.nonNull(product.getInventoryStatus()) ? product.getInventoryStatus() : productEntity.getInventoryStatus())
                .rating(Objects.nonNull(product.getRating()) ? product.getRating() : productEntity.getRating())
                .build();
    }
}
