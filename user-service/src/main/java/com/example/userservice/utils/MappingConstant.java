package com.example.userservice.utils;

public class MappingConstant {
    private MappingConstant(){}

    public static class UserMapping{
        private UserMapping(){}

        public static final String HELLO = "/hello";
        public static final String BASE="/api/v1/users";
        public static final String CREATE = "/create";
        public static final String GET_ALL = "/get-all";
        public static final String GET_BY_ID = "/{id}";
        public static final String UPDATE = "/update/{id}";
        public static final String DELETE = "/delete/{id}";
    }
}
