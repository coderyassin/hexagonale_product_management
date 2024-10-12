package org.alten.product_management.domain.services;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.input.DeleteProductUseCase;
import org.alten.product_management.domain.port.output.DeleteProductPort;

public class DeleteProductService implements DeleteProductUseCase {
    private final DeleteProductPort deleteProductPort;

    public DeleteProductService(DeleteProductPort deleteProductPort) {
        this.deleteProductPort = deleteProductPort;
    }

    @Override
    public Product deleteProduct(String productId) {
        try {
            return deleteProductPort.deleteProduct(productId);
        } catch (Exception e) {
            throw e;
        }
    }
}
