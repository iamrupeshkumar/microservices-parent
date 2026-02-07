package com.example.exception;

import com.example.error.ErrorCode;

public class ResourceNotFoundException extends BusinessException{
    public ResourceNotFoundException(String message) {
        super(ErrorCode.USER_NOT_FOUND, message);
    }
}
