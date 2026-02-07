package com.example.error;

import java.time.LocalDateTime;

public class ErrorResponse {
    private ErrorCode errorCode;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(ErrorCode errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
