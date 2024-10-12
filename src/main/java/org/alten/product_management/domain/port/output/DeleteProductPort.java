package org.alten.product_management.domain.port.output;

import org.alten.product_management.domain.model.Product;

public interface DeleteProductPort {
    Product deleteProduct(String productId);
}
