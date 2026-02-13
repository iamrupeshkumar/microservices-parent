package com.example.userservice.utils;

public class MappingConstant {
    private MappingConstant(){}

    public static class UserMapping{
        private UserMapping(){}

        public static final String HELLO = "/hello";
        public static final String BASE="/api/v1/users";
        public static final String GET_BY_ID = "/{userId}";
    }
}
