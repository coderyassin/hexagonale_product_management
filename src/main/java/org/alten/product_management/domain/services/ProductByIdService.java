package org.alten.product_management.domain.services;

import org.alten.product_management.domain.exception.ResourceNotFoundException;
import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.input.ProductByIdUseCase;
import org.alten.product_management.domain.port.output.ProductByIdPort;

import static org.alten.product_management.domain.constant.ProductConstant.PRODUCT_NOT_FOUND;

public class ProductByIdService implements ProductByIdUseCase {
    private final ProductByIdPort productByIdPort;

    public ProductByIdService(ProductByIdPort productByIdPort) {
        this.productByIdPort = productByIdPort;
    }

    @Override
    public Product productById(Long productId) {
        return productByIdPort.findById(productId)
                .orElseThrow(() -> {
                    String message = String.format(PRODUCT_NOT_FOUND, productId);
                    return new ResourceNotFoundException((message));
                });
    }
}
