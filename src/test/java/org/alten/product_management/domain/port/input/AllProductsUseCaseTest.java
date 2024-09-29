package org.alten.product_management.domain.port.input;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.AllProductsPort;
import org.alten.product_management.domain.services.AllProductsService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AllProductsUseCaseTest {

    @Mock
    AllProductsPort allProductsPort;

    @InjectMocks
    AllProductsService allProductsService;

    @Test
    void should_return_products() {
        Product product1 = new Product();
        product1.setId(1L);

        Product product2 = new Product();
        product2.setId(2L);

        when(allProductsPort.allProducts()).thenReturn(List.of(product1, product2));

        List<Product> products = allProductsService.allProducts();

        Assertions.assertThat(products).hasSize(2);
    }
}
