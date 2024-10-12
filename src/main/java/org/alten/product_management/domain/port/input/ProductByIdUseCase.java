package org.alten.product_management.domain.port.input;

import org.alten.product_management.domain.model.Product;

public interface ProductByIdUseCase {
    Product productById(String productId);
}
