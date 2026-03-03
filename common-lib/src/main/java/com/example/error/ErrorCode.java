package com.example.error;

public enum ErrorCode {
    //General
    INTERNAL_SERVER_ERROR,
    INVALID_REQUEST,

    // user domain
    NOT_FOUND,
    USER_ALREADY_EXISTS,

    // Auth
    UNAUTHORIZED,
    FORBIDDEN,

    // Communication
    SERVICE_UNAVAILABLE

}
