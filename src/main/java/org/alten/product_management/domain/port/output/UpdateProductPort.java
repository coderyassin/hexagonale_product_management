package org.alten.product_management.domain.port.output;

import org.alten.product_management.domain.model.Product;

public interface UpdateProductPort {
    Product updateProduct(Product product, Long productId);
}
