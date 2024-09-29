package org.alten.product_management.domain.port.input;

import org.alten.product_management.domain.model.Product;

public interface UpdateProductUseCase {
    Product updateProduct(Product product, Long productId);
}
