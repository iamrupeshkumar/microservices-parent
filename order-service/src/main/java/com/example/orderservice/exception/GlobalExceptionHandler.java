package com.example.orderservice.exception;

import com.example.error.ErrorCode;
import com.example.error.ErrorResponse;
import com.example.exception.BusinessException;
import com.example.exception.ResourceNotFoundException;
import com.example.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle Business Exceptions
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiResponse<Object>> handleBusinessException(BusinessException e){

        ErrorCode errorCode = e.getErrorCode();
        ErrorResponse errorResponse = new ErrorResponse(errorCode,e.getMessage());

        ApiResponse<Object> apiResponse = ApiResponse.builder()
                .success(false)
                .message("Business Error")
                .data(null)
                .error(errorResponse)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(apiResponse, ErrorCodeHttpStatusMapper.getHttpStatus(errorCode));
    }

    // Handle Resource Not Found Exceptions
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleResourceNotFoundException(ResourceNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode(),e.getMessage());
        ApiResponse<Object> apiResponse = ApiResponse.builder()
                .success(false)
                .message("Resource Not Found!!")
                .data(null)
                .error(errorResponse)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    // Handle all other exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception e){
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, e.getMessage());

        ApiResponse<Object> response = ApiResponse.builder()
                .success(false)
                .message("Internal Server Error")
                .data(null)
                .error(errorResponse)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
