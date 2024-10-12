package org.alten.product_management.infrastructure.adapter.output.db.business;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.AllProductsPort;
import org.alten.product_management.infrastructure.adapter.output.db.service.AllProductsService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllProductsAdapter implements AllProductsPort {
    private final AllProductsService allProductsService;

    public AllProductsAdapter(/*@Qualifier("AllProductsFromMongoDB") @Qualifier("AllProductsFromMySql")*/
                              AllProductsService allProductsService) {
        this.allProductsService = allProductsService;
    }

    @Override
    public List<Product> allProducts() {
        return allProductsService.allProducts();
    }
}
