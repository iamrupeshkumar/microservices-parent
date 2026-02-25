package com.example.userservice.exception;

import com.example.error.ErrorCode;
import org.springframework.http.HttpStatus;

import java.util.EnumMap;
import java.util.Map;

public class ErrorCodeHttpStatusMapper {
    private static final Map<ErrorCode, HttpStatus> statusMap = new EnumMap<>(ErrorCode.class);

    static{
        statusMap.put(ErrorCode.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        statusMap.put(ErrorCode.INVALID_REQUEST, HttpStatus.BAD_REQUEST);

        statusMap.put(ErrorCode.USER_NOT_FOUND, HttpStatus.NOT_FOUND);
        statusMap.put(ErrorCode.USER_ALREADY_EXISTS,HttpStatus.CONFLICT);

        statusMap.put(ErrorCode.UNAUTHORIZED, HttpStatus.UNAUTHORIZED);
        statusMap.put(ErrorCode.FORBIDDEN, HttpStatus.FORBIDDEN);
    }

    public static HttpStatus getHttpStatus(ErrorCode errorCode){
        return statusMap.getOrDefault(errorCode, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
