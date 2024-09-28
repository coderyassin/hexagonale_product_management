package org.alten.product_management.application.common.util;

public class ApiPaths {
    public static class Product {
        public static final String API = "api/";
        public static final String VERSION = "v2";
        public static final String PATH = API + VERSION;
        public static final String PRODUCTS = PATH + "/products";
        public static final String PRODUCT_ID = "/{productId}";
    }
}
