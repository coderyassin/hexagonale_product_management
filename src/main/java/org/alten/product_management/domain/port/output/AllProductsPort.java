package org.alten.product_management.domain.port.output;

import org.alten.product_management.domain.model.Product;

import java.util.List;

public interface AllProductsPort {
    List<Product> allProducts();
}
