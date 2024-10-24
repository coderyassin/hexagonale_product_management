package org.alten.product_management.infrastructure.adapter.output.db.business;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.DeleteProductPort;
import org.alten.product_management.infrastructure.adapter.output.db.service.DeleteProductService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductAdapter implements DeleteProductPort {
    private final DeleteProductService deleteProductService;

    public DeleteProductAdapter(DeleteProductService deleteProductService) {
        this.deleteProductService = deleteProductService;
    }

    @Override
    @CacheEvict(value = "users", key = "#productId")
    public Product deleteProduct(String productId) {
        return deleteProductService.deleteProduct(productId);
    }
}
