package org.alten.product_management.domain.services;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.input.UpdateProductUseCase;
import org.alten.product_management.domain.port.output.UpdateProductPort;

public class UpdateProductService implements UpdateProductUseCase {
    private final UpdateProductPort updateProductPort;

    public UpdateProductService(UpdateProductPort updateProductPort) {
        this.updateProductPort = updateProductPort;
    }

    @Override
    public Product updateProduct(Product product, String productId) {
        try {
            return updateProductPort.updateProduct(product, productId);
        } catch (Exception e) {
            throw e;
        }
    }
}
