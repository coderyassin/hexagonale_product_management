package org.alten.product_management.domain.port.input;

import org.alten.product_management.domain.model.Product;

import java.util.List;

public interface AllProductsUseCase {
    List<Product> allProducts();
}
