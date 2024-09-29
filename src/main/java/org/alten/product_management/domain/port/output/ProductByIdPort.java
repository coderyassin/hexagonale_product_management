package org.alten.product_management.domain.port.output;

import org.alten.product_management.domain.model.Product;

import java.util.Optional;

public interface ProductByIdPort {
    Optional<Product> findById(Long productId);
}
