package com.example.orderservice.utils;

import com.example.error.ErrorCode;
import com.example.exception.BusinessException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class FeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {

        switch (response.status()){
            case 404:
                return new BusinessException(
                        ErrorCode.NOT_FOUND,
                        extractMessage(response)
                );
            default:
                return defaultDecoder.decode(methodKey, response);
        }
    }

    private String extractMessage(Response response) {
        try {
            byte[] body = response.body().asInputStream().readAllBytes();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(body);
            // Navigates your ApiResponse structure → error → message
            return root.path("error").path("message").asText("User not found");
        } catch (Exception e) {
            return "User not found";
        }
    }
}
