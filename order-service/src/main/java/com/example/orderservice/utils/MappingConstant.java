package com.example.orderservice.utils;

public class MappingConstant {
    private MappingConstant() {}

    public static class OrderMapping{
        private OrderMapping() {}

        public static final String HELLO = "/hello";
        public static final String BASE="/api/v1/orders";
        public static final String CREATE = "/create/{userId}";
    }
}
