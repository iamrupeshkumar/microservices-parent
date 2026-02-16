package com.example.error;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse {
    private ErrorCode errorCode;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
