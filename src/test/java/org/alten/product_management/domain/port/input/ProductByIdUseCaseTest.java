package org.alten.product_management.domain.port.input;

import org.alten.product_management.domain.model.Product;
import org.alten.product_management.domain.port.output.ProductByIdPort;
import org.alten.product_management.domain.services.ProductByIdService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductByIdUseCaseTest {
    @Mock
    ProductByIdPort productByIdPort;

    @InjectMocks
    ProductByIdService productByIdService;

    @Test
    void should_return_product() {
        final Product product = new Product();
        product.setId(1L);
        product.setName("Name X");
        product.setDescription("Description X");

        when(productByIdPort.findById(1L)).thenReturn(Optional.of(product));

        assertEquals("Name X", productByIdService.productById(1L).getName());
        assertEquals("Description X", productByIdService.productById(1L).getDescription());
    }
}
