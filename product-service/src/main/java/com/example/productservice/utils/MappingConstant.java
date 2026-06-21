package com.example.productservice.utils;

public class MappingConstant {
    private MappingConstant() {}

    public static class ProductMapping{
        private ProductMapping() {}

        public static final String HELLO = "/hello";
        public static final String BASE="/api/v1/products";
        public static final String CREATE = "/create";
        public static final String GET_BY_ID = "/{id}";
    }
}
