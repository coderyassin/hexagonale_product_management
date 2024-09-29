package org.alten.product_management.domain.port.input;

import org.alten.product_management.domain.exception.ErrorMessage;
import org.alten.product_management.domain.exception.ParameterNotFoundException;
import org.alten.product_management.domain.exception.ResourceNotCreatedException;

public interface ProductNotCreatedUseCase {
    ErrorMessage productNotCreated(ResourceNotCreatedException ex, String description);
    ErrorMessage productNotCreated(ParameterNotFoundException ex, String description);
}
