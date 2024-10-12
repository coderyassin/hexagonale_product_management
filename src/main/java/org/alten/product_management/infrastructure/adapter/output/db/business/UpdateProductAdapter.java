package org.alten.product_management.infrastructure.adapter.output.db.business;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.UpdateProductPort;
import org.alten.product_management.infrastructure.adapter.output.db.service.UpdateProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductAdapter implements UpdateProductPort {
    private final UpdateProductService updateProductService;

    public UpdateProductAdapter(/*@Qualifier("UpdateProductFromMongoDB") @Qualifier("UpdateProductFromMySql")*/
                                UpdateProductService updateProductService) {
        this.updateProductService = updateProductService;
    }

    @Override
    public Product updateProduct(Product product, String productId) {
        return updateProductService.updateProduct(product, productId);
    }
}
