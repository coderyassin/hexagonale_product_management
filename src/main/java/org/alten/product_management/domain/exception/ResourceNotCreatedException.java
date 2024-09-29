package org.alten.product_management.domain.exception;

public class ResourceNotCreatedException extends RuntimeException {

    public ResourceNotCreatedException(String msg) {
        super(msg);
    }

    public ResourceNotCreatedException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotCreatedException(Throwable cause) {
        super(cause);
    }

}
