package org.alten.product_management.infrastructure.adapter.output.db.business;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.ProductByIdPort;
import org.alten.product_management.infrastructure.adapter.output.db.service.ProductByIdService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProductByIdAdapter implements ProductByIdPort {
    private final ProductByIdService productByIdService;

    public ProductByIdAdapter(@Qualifier("ProductByIdFromMongoDB")/*@Qualifier("ProductByIdFromMySql")*/
                              ProductByIdService productByIdService) {
        this.productByIdService = productByIdService;
    }

    @Override
    public Optional<Product> findById(String productId) {
        return productByIdService.findById(productId);
    }
}
