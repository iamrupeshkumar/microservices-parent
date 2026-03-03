package com.example.exception;

import com.example.error.ErrorCode;

public class ResourceNotFoundException extends BusinessException{
    public ResourceNotFoundException(String message) {
        super(ErrorCode.NOT_FOUND, message);
    }
}
